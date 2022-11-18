package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.vo.EnergyConsumptionVo;

import java.util.List;
import java.util.Map;

public interface EnergyConsumptionService {
    Map<String, Double> getEnergyConsumption(EnergyConsumptionVo energyConsumptionVo);

    boolean existHistory(Integer id, String year);

    Page<Map<String,Object>> page(Map<String, Object> params);

    List<Map<String, String>> getEnergyByInstitutionId(Integer institutionId, String date);

    boolean remove(Integer institutionId, String date);
}
