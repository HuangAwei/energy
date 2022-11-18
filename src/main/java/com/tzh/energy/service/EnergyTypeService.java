package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tzh.energy.entity.EnergyType;

import java.util.Map;

/**
* @author hw
* @description 针对表【energy_type(能源类型)】的数据库操作Service
* @createDate 2022-11-11 11:00:07
*/
public interface EnergyTypeService extends IService<EnergyType> {

    Page<EnergyType> energyTypePage(Map<String, Object> params);
}
