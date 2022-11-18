package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tzh.energy.entity.RiskHistory;
import com.tzh.energy.vo.RiskAssessmentVo;

import java.util.Map;

/**
* @author hw
* @description 针对表【risk_history】的数据库操作Service
* @createDate 2022-11-14 14:28:28
*/
public interface RiskHistoryService extends IService<RiskHistory> {

    double riskAssessment(RiskAssessmentVo riskAssessmentVo);

    Page<RiskHistory> energyTypePage(Map<String, Object> params);
}
