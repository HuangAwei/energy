package com.tzh.energy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.entity.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author hw
* @description 针对表【device(设备)】的数据库操作Mapper
* @createDate 2022-11-30 14:50:18
* @Entity generator.domain.Device
*/
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

    List<Map<String, Object>> devicePage(@Param("page") Page<Map<String, Object>> page, @Param("name") String name,@Param("type") String type);
}




