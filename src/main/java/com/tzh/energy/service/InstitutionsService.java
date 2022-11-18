package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tzh.energy.entity.Institutions;

import java.util.Map;

/**
* @author hw
* @description 针对表【institutions】的数据库操作Service
* @createDate 2022-11-11 11:00:07
*/
public interface InstitutionsService extends IService<Institutions> {

    Page<Institutions> institutionsPage(Map<String, Object> params);
}
