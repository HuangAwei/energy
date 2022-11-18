package com.tzh.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzh.energy.entity.Institutions;
import com.tzh.energy.mapper.InstitutionsMapper;
import com.tzh.energy.service.InstitutionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
* @author hw
* @description 针对表【institutions】的数据库操作Service实现
* @createDate 2022-11-11 11:00:07
*/
@Service
public class InstitutionsServiceImpl extends ServiceImpl<InstitutionsMapper, Institutions> implements InstitutionsService {

    @Resource
    public InstitutionsMapper institutionsMapper;

    @Override
    public Page<Institutions> institutionsPage(Map<String, Object> params) {
        int current = 1, size = 10;
        if (params.containsKey("current") && params.get("current") != ""){
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.containsKey("size") && params.get("size") != "size"){
            size = Integer.parseInt((String) params.get("size"));
        }
        QueryWrapper<Institutions> wrapper = new QueryWrapper<>();
        if (params.containsKey("name") && params.get("name") != ""){
            wrapper.like("name",params.get("name"));
        }
        if (params.containsKey("type") && params.get("type") != ""){
            wrapper.eq("type",params.get("type"));
        }
        //分页对象
        Page<Institutions> page = new Page<>(current, size);
        page = this.page(page,wrapper);
        return page;
    }
}




