package com.tzh.energy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.common.Result;
import com.tzh.energy.entity.Institutions;
import com.tzh.energy.entity.InstitutionsType;
import com.tzh.energy.service.InstitutionsService;
import com.tzh.energy.service.InstitutionsTypeService;
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
@RequestMapping("/institutions")
@Api(tags="机构api")
public class InstitutionsController {

    @Resource
    public InstitutionsService institutionsService;

    @Resource
    public InstitutionsTypeService institutionsTypeService;


    @GetMapping("page")
    @ApiOperation("机构分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "name", value = "机构名称", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "type", value = "机构类型", paramType = "query", dataType="int")
    })
    public Result<Page<Institutions>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        Page<Institutions> page = institutionsService.institutionsPage(params);
        return Result.success().data(page);
    }

    @PostMapping("save")
    @ApiOperation("保存机构")
    public Result save(@RequestBody Institutions institutions){
        Result save;
        if (institutions.getName() == null || institutions.getType() == null){
            save = Result.error().message("名称或类型为空");
        }else if (institutions.getId() == null){
            save = institutionsService.save(institutions) ? Result.success() : Result.error();
        }else {
            save = institutionsService.updateById(institutions) ? Result.success() : Result.error();
        }
        return save;
    }

    @PostMapping("remove")
    @ApiOperation("删除机构")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result remove(@RequestBody Integer[] ids){
        return institutionsService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }

    @GetMapping("getAllType")
    @ApiOperation("获取所有机构类型")
    public Result<InstitutionsType> getAllType(){
        return Result.success().data(institutionsTypeService.list());
    }

    @GetMapping("getAll")
    @ApiOperation("获取所有机构")
    public Result<InstitutionsType> getAll(){
        return Result.success().data(institutionsService.list());
    }

}
