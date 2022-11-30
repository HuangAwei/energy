package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tzh.energy.entity.Device;

import java.util.Map;

/**
* @author hw
* @description 针对表【device(设备)】的数据库操作Service
* @createDate 2022-11-30 14:50:18
*/
public interface DeviceService extends IService<Device> {

    Page<Map<String, Object>> devicePage(Map<String, Object> params);

    boolean existDevice(Device device);
}
