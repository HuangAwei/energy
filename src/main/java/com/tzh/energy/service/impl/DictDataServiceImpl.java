package com.tzh.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzh.energy.entity.DictData;
import com.tzh.energy.entity.DictType;
import com.tzh.energy.entity.EnergyType;
import com.tzh.energy.mapper.DictDataMapper;
import com.tzh.energy.service.DictDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author hw
* @description 针对表【dict_data(字典数据)】的数据库操作Service实现
* @createDate 2022-11-18 13:24:26
*/
@Service
public class DictDataServiceImpl extends ServiceImpl<DictDataMapper, DictData> implements DictDataService {

    @Override
    public Page<DictData> dataPage(Map<String, Object> params) {
        int current = 1, size = 10;
        if (params.containsKey("current") && params.get("current") != ""){
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.containsKey("size") && params.get("size") != ""){
            size = Integer.parseInt((String) params.get("size"));
        }
        QueryWrapper<DictData> wrapper = new QueryWrapper<>();
        if (params.containsKey("dictType") && params.get("dictType") != ""){
            wrapper.eq("dict_type",params.get("dictType"));
        }
        //分页对象
        Page<DictData> page = new Page<>(current, size);
        page = this.page(page,wrapper);
        return page;
    }

    @Override
    public List<DictData> typeList() {
        QueryWrapper<DictData> wrapper = new QueryWrapper<>();
        wrapper.eq("dict_type","device");
        return this.list(wrapper);
    }
}




