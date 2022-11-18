package com.tzh.energy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tzh.energy.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hw
* @description 针对表【dept(部门管理)】的数据库操作Mapper
* @createDate 2022-11-18 13:24:26
* @Entity generator.domain.Dept
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}




