package com.tzh.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tzh.energy.entity.User;

import java.util.Map;

/**
* @author hw
* @description 针对表【user(系统用户)】的数据库操作Service
* @createDate 2022-11-18 13:24:26
*/
public interface UserService extends IService<User> {

    Page<Map<String, Object>> userPage(Map<String, Object> params);

    boolean existUserName(String username,Integer id);
}
