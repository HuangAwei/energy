package com.tzh.energy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.entity.EnergyConsumption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
* @author hw
* @description 针对表【energy_consumption】的数据库操作Mapper
* @createDate 2022-11-14 09:36:26
* @Entity generator.domain.EnergyConsumption
*/
@Mapper
public interface EnergyConsumptionMapper extends BaseMapper<EnergyConsumption> {

    List<Map<String, Object>> getHistory(@Param("page")Page<Map<String,Object>> page,@Param("name") String name, @Param("date") String date);
}




