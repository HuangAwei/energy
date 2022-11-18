package com.tzh.energy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tzh.energy.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hw
* @description 针对表【user(系统用户)】的数据库操作Mapper
* @createDate 2022-11-18 13:24:26
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




