package com.tzh.energy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author hw
* @description 针对表【user(系统用户)】的数据库操作Mapper
* @createDate 2022-11-18 13:24:26
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<Map<String, Object>> userPage(@Param("page") Page page,@Param("realName") String realName,@Param("gender") String gender,@Param("deptId") String deptId);
}




