package com.tzh.energy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.common.Result;
import com.tzh.energy.entity.EnergyConsumption;
import com.tzh.energy.service.EnergyConsumptionService;
import com.tzh.energy.vo.EnergyConsumptionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("energyConsumption")
@Api(tags="能耗api")
public class EnergyConsumptionController {

    @Resource
    public EnergyConsumptionService energyConsumptionService;

    @PostMapping("/getEnergyConsumption")
    @ApiOperation("能耗计算")
    public Result getEnergyConsumption(@RequestBody EnergyConsumptionVo energyConsumptionVo){
        Result result;
        if (energyConsumptionService.existHistory(energyConsumptionVo.getInstitutionId(),energyConsumptionVo.getDate())){
            result = Result.error().message("机构" + energyConsumptionVo.getDate() + "年数据已存在");
        }else {
            Map<String, Double> energyConsumption = energyConsumptionService.getEnergyConsumption(energyConsumptionVo);
            result = Result.success().data(energyConsumption);
        }
        return result;
    }

    @GetMapping("page")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "name", value = "机构名称", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "date", value = "统计年份", paramType = "query", dataType="String")
    })
    public Result<Page<EnergyConsumption>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        Page<Map<String, Object>> page = energyConsumptionService.page(params);
        return Result.success().data(page);
    }

    @GetMapping("getEnergyByInstitutionId/{institutionId}/{date}")
    @ApiOperation("根据机构id及统计时间获取能源使用情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "institutionId", value = "机构id", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "date", value = "机构id", paramType = "query", required = true, dataType = "String")
    })
    public Result<Map<String,String>> getEnergyByInstitutionId(@PathVariable("institutionId") Integer institutionId, @PathVariable("date") String date){
        List<Map<String,String>> list = energyConsumptionService.getEnergyByInstitutionId(institutionId,date);
        return Result.success().data(list);
    }

    @GetMapping("remove/{institutionId}/{date}")
    @ApiOperation("删除能耗记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "institutionId", value = "机构id", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "date", value = "机构id", paramType = "query", required = true, dataType = "String")
    })
    public Result remove(@PathVariable("institutionId") Integer institutionId, @PathVariable("date") String date){
        return energyConsumptionService.remove(institutionId,date) ? Result.success() : Result.error();
    }
}
