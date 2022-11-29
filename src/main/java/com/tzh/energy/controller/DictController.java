package com.tzh.energy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.common.Result;
import com.tzh.energy.entity.DictData;
import com.tzh.energy.entity.DictType;
import com.tzh.energy.service.DictDataService;
import com.tzh.energy.service.DictTypeService;
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
@RequestMapping("dict")
@Api(tags="字典api")
public class DictController {
    @Resource
    public DictTypeService dictTypeService;
    @Resource
    public DictDataService dictDataService;

    @GetMapping("typeList")
    @ApiOperation("获取字典类型列表")
    public Result<List<DictType>> typeList(){
        List<DictType> list = dictTypeService.list();
        return Result.success().data(list);
    }

    @PostMapping("removeType")
    @ApiOperation("删除字典类型")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result removeType(@RequestBody Integer[] ids){
        return dictTypeService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }

    @PostMapping("saveType")
    @ApiOperation("保存字典类型")
    public Result saveType(@RequestBody DictType dictType){
        Result save;
        if (dictType.getDictType() == null || dictType.getDictName() == null){
            save = Result.error().message("名称或类型为空");
        }else if (dictType.getId() == null){
            save = dictTypeService.save(dictType) ? Result.success() : Result.error();
        }else {
            save = dictTypeService.updateById(dictType) ? Result.success() : Result.error();
        }
        return save;
    }


    @GetMapping("dataPage")
    @ApiOperation("字典类型数据分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "dictType", value = "字典类型", paramType = "query", dataType="String")
    })
    public Result<Page<DictData>> dataPage(@ApiIgnore @RequestParam Map<String, Object> params){
        Page<DictData> page = dictDataService.dataPage(params);
        return Result.success().data(page);
    }

    @PostMapping("removeData")
    @ApiOperation("删除字典类型数据")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result removeData(@RequestBody Integer[] ids){
        return dictDataService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }

    @PostMapping("saveData")
    @ApiOperation("保存字典类型数据")
    public Result saveData(@RequestBody DictData dictData){
        Result save;
        if (dictData.getDictType() == null || dictData.getDictLabel() == null || dictData.getDictValue() == null){
            save = Result.error().message("字典类型、数据值、数据名不能为空为空");
        }else if (dictData.getId() == null){
            save = dictDataService.save(dictData) ? Result.success() : Result.error();
        }else {
            save = dictDataService.updateById(dictData) ? Result.success() : Result.error();
        }
        return save;
    }
}
