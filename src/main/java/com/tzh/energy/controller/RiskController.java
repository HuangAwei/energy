package com.tzh.energy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.common.Result;
import com.tzh.energy.entity.RiskHistory;
import com.tzh.energy.service.RiskHistoryService;
import com.tzh.energy.vo.RiskAssessmentVo;
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
@RequestMapping("/risk")
@Api(tags="风险评价api")
public class RiskController {

    @Resource
    public RiskHistoryService riskHistoryService;

    @PostMapping("riskAssessment")
    @ApiOperation("风险系数计算")
    public Result riskAssessment(@RequestBody RiskAssessmentVo riskAssessmentVo){
        double result = riskHistoryService.riskAssessment(riskAssessmentVo);
        return Result.success().data(result);
    }

    @GetMapping("page")
    @ApiOperation("风险评价分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "name", value = "项目名称", paramType = "query", dataType="String")
    })
    public Result<Page<RiskHistory>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        Page<RiskHistory> page = riskHistoryService.energyTypePage(params);
        return Result.success().data(page);
    }

    @PostMapping("remove")
    @ApiOperation("删除风险评价记录")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result remove(@RequestBody Integer[] ids){
        return riskHistoryService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }
}
