package com.tzh.energy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzh.energy.entity.Dept;
import com.tzh.energy.mapper.DeptMapper;
import com.tzh.energy.service.DeptService;
import com.tzh.energy.utils.TreeUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hw
* @description 针对表【dept(部门管理)】的数据库操作Service实现
* @createDate 2022-11-18 13:24:26
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Override
    public List<Dept> deptList() {
        return TreeUtils.build(this.list());
    }
}




