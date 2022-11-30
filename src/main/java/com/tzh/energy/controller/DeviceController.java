package com.tzh.energy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.common.Result;
import com.tzh.energy.entity.Device;
import com.tzh.energy.entity.DictData;
import com.tzh.energy.service.DeviceService;
import com.tzh.energy.service.DictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/device")
@Api(tags="设备api")
public class DeviceController {
    @Resource
    public DeviceService deviceService;
    @Resource
    public DictDataService dictDataService;

    @GetMapping("typeList")
    @ApiOperation("获取所有设备类型")
    public Result<List<DictData>> typeList(){
        List<DictData> typeList = dictDataService.typeList();
        return Result.success().data(typeList);
    }

    @GetMapping("page")
    @ApiOperation("设备信息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "name", value = "设备名", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "type", value = "设备类型", paramType = "query", dataType="String")
    })
    public Result<Page<Map<String, Object>>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        Page<Map<String, Object>> devicePage = deviceService.devicePage(params);
        return Result.success().data(devicePage);
    }

    @PostMapping("save")
    @ApiOperation("保存设备信息")
    public Result save(@RequestBody Device device) {
        boolean save = false;
        String message = "";
        boolean exist = deviceService.existDevice(device);
        if (exist){
            message = "设备名重复";
        } else if (device.getId() != null){
            save = deviceService.updateById(device);
        }else {
            save = deviceService.save(device);
        }
        return save ? Result.success() : Result.error().message(message);
    }

    @PostMapping("remove")
    @ApiOperation("删除设备")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result remove(@RequestBody Integer[] ids){
        return deviceService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }

}
