package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tzh.energy.entity.DictData;
import com.tzh.energy.entity.DictType;

import java.util.List;
import java.util.Map;

/**
* @author hw
* @description 针对表【dict_data(字典数据)】的数据库操作Service
* @createDate 2022-11-18 13:24:26
*/
public interface DictDataService extends IService<DictData> {

    Page<DictData> dataPage(Map<String, Object> params);

    List<DictData> typeList();
}
