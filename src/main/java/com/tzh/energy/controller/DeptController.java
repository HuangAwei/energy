package com.tzh.energy.controller;


import com.tzh.energy.common.Result;
import com.tzh.energy.entity.Dept;
import com.tzh.energy.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dept")
@Api(tags="部门管理api")
public class DeptController {

    @Resource
    public DeptService deptService;

    @GetMapping("list")
    @ApiOperation("获取部门列表")
    public Result<List<Dept>> page() {
        List<Dept> deptList = deptService.deptList();
        return Result.success().data(deptList);
    }

    @PostMapping("save")
    @ApiOperation("保存部门信息")
    public Result save(@RequestBody Dept dept) {
        boolean save = false;
        if (dept.getId() != null){
            save = deptService.updateById(dept);
        }else {
            save = deptService.save(dept);
        }
        return save ? Result.success() : Result.error();
    }

    @PostMapping("remove")
    @ApiOperation("删除部门")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result remove(@RequestBody Integer[] ids){
        return deptService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }
}