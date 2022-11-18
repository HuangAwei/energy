package com.tzh.energy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tzh.energy.entity.EnergyType;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hw
* @description 针对表【energy_type(能源类型)】的数据库操作Mapper
* @createDate 2022-11-11 11:00:07
* @Entity generator.domain.EnergyType
*/
@Mapper
public interface EnergyTypeMapper extends BaseMapper<EnergyType> {

}




