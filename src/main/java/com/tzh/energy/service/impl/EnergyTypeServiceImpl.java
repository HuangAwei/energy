package com.tzh.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzh.energy.entity.EnergyType;
import com.tzh.energy.mapper.EnergyTypeMapper;
import com.tzh.energy.service.EnergyTypeService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author hw
* @description 针对表【energy_type(能源类型)】的数据库操作Service实现
* @createDate 2022-11-11 11:00:07
*/
@Service
public class EnergyTypeServiceImpl extends ServiceImpl<EnergyTypeMapper, EnergyType> implements EnergyTypeService {


    @Override
    public Page<EnergyType> energyTypePage(Map<String, Object> params) {
        int current = 1, size = 10;
        if (params.containsKey("current") && params.get("current") != ""){
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.containsKey("size") && params.get("size") != ""){
            size = Integer.parseInt((String) params.get("size"));
        }
        QueryWrapper<EnergyType> wrapper = new QueryWrapper<>();
        if (params.containsKey("name") && params.get("name") != ""){
            wrapper.like("name",params.get("name"));
        }
        if (params.containsKey("order") && params.get("order") != ""){
            if (0 == Integer.parseInt((String) params.get("order"))){
                wrapper.orderByAsc("p");
            }else if (1 == Integer.parseInt((String) params.get("order"))){
                wrapper.orderByDesc("p");
            }
        }
        //分页对象
        Page<EnergyType> page = new Page<>(current, size);
        page = this.page(page,wrapper);
        return page;
    }
}




