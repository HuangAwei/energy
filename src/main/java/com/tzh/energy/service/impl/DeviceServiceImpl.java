package com.tzh.energy.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzh.energy.entity.Device;
import com.tzh.energy.mapper.DeviceMapper;
import com.tzh.energy.service.DeviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @author hw
* @description 针对表【device(设备)】的数据库操作Service实现
* @createDate 2022-11-30 14:50:18
*/
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Resource
    public DeviceMapper deviceMapper;

    @Override
    public Page<Map<String, Object>> devicePage(Map<String, Object> params) {
        int current = 1, size = 10;
        String name = null;
        if (params.containsKey("current") && params.get("current") != ""){
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.containsKey("size") && params.get("size") != ""){
            size = Integer.parseInt((String) params.get("size"));
        }
        if (params.containsKey("name") && params.get("name") != ""){
            name = "%" + params.get("name") + "%";
        }
        Page<Map<String, Object>> page = new Page<>(current, size);
        List<Map<String, Object>> maps = deviceMapper.devicePage(page, name, (String) params.get("type"));
        page.setRecords(maps);
        return page;
    }

    @Override
    public boolean existDevice(Device device) {
        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        wrapper.eq("name",device.getName());
        if (device.getId() != null){
            wrapper.ne("id",device.getId());
        }
        List<Device> list = this.list(wrapper);
        return list.size() > 0;
    }
}




