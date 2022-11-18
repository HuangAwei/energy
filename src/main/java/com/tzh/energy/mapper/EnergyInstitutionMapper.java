package com.tzh.energy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tzh.energy.entity.EnergyInstitution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author hw
* @description 针对表【energy_institution】的数据库操作Mapper
* @createDate 2022-11-14 09:04:24
* @Entity generator.domain.EnergyInstitution
*/
@Mapper
public interface EnergyInstitutionMapper extends BaseMapper<EnergyInstitution> {


    int existHistory(@Param("id") Integer id,@Param("year") String year);

    List<Map<String, String>> getEnergyByInstitutionId(@Param("institutionId") Integer institutionId, @Param("date") String date);
}




