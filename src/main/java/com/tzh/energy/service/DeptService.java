package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzh.energy.entity.Dept;

import java.util.List;

/**
* @author hw
* @description 针对表【dept(部门管理)】的数据库操作Service
* @createDate 2022-11-18 13:24:26
*/
public interface DeptService extends IService<Dept> {

    List<Dept> deptList();
}
