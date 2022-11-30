package com.tzh.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzh.energy.entity.User;
import com.tzh.energy.mapper.UserMapper;
import com.tzh.energy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @author hw
* @description 针对表【user(系统用户)】的数据库操作Service实现
* @createDate 2022-11-18 13:24:26
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    public UserMapper userMapper;

    @Override
    public Page<Map<String, Object>> userPage(Map<String, Object> params) {
        int current = 1, size = 10;
        String realName = null;
        if (params.containsKey("current") && params.get("current") != ""){
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.containsKey("size") && params.get("size") != ""){
            size = Integer.parseInt((String) params.get("size"));
        }
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (params.containsKey("realName") && params.get("realName") != ""){
            realName = "%" + params.get("realName") + "%";
//            wrapper.like("real_name",realName);
        }
//        if (params.containsKey("gender") && params.get("gender") != ""){
//            wrapper.eq("gender",params.get("gender"));
//        }
//        if (params.containsKey("deptId") && params.get("deptId") != ""){
//            wrapper.eq("dept_id",params.get("deptId"));
//        }
        Page<Map<String, Object>> page = new Page<>(current, size);
//        page = this.page(page,wrapper);
        List<Map<String, Object>> maps = userMapper.userPage(page, realName, (String) params.get("gender"), (String) params.get("deptId"));
        page.setRecords(maps);
        return page;
    }

    @Override
    public boolean existUserName(String username, Integer id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        if (id != null ){
            wrapper.ne("id", id);
        }
        return this.count(wrapper) > 0;
    }
}




