package com.tzh.energy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.common.Result;
import com.tzh.energy.entity.EnergyType;
import com.tzh.energy.service.EnergyTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/energyType")
@Api(tags="能源类型api")
public class EnergyTypeController {
    @Resource
    public EnergyTypeService energyTypeService;

    @GetMapping("page")
    @ApiOperation("能源类型分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "name", value = "能源类型名称", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "order", value = "排序方式：0：标准煤系数升序，1：标准煤系数降序", paramType = "query", dataType="int")
    })
    public Result<Page<EnergyType>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        Page<EnergyType> page = energyTypeService.energyTypePage(params);
        return Result.success().data(page);
    }

    @PostMapping("save")
    @ApiOperation("保存能源类型")
    public Result save(@RequestBody EnergyType energyType){
        Result save;
        if (energyType.getName() == null || energyType.getP() == null){
            save = Result.error().message("名称或标准煤系数为空");
        }else if (energyType.getId() == null){
            save = energyTypeService.save(energyType) ? Result.success() : Result.error();
        }else {
            save = energyTypeService.updateById(energyType) ? Result.success() : Result.error();
        }
        return save;
    }

    @PostMapping("remove")
    @ApiOperation("删除能源类型")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result remove(@RequestBody Integer[] ids){
        return energyTypeService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }

    @GetMapping("getAll")
    @ApiOperation("获取所有能源类型")
    public Result getAll(){
        return Result.success().data(energyTypeService.list());
    }
}
