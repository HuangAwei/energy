package com.tzh.energy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.common.Result;
import com.tzh.energy.entity.User;
import com.tzh.energy.service.UserService;
import com.tzh.energy.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(tags="用户管理api")
public class UserController {
    @Resource
    public UserService userService;

    @GetMapping("page")
    @ApiOperation("用户信息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "realName", value = "姓名", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "gender", value = "性别", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "deptId", value = "部门ID", paramType = "query", dataType="String")
    })
    public Result<Page<User>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        Page<User> userPage = userService.userPage(params);
        return Result.success().data(userPage);
    }

    @PostMapping("save")
    @ApiOperation("保存用户信息")
    public Result save(@RequestBody User user) {
        boolean save = false;
        String message = "";
        user.setPassword(MD5Utils.getMD5(user.getPassword()));
        if (userService.existUserName(user.getUsername())){
            message = "用户名已存在";
        }else if (user.getId() != null){
            save = userService.updateById(user);
        }else {
            save = userService.save(user);
        }
        return save ? Result.success() : Result.error().message(message);
    }

    @PostMapping("remove")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "ids", value = "id数组", paramType = "body", required = true, dataType="int")
    public Result remove(@RequestBody Integer[] ids){
        return userService.removeByIds(Arrays.asList(ids)) ? Result.success() : Result.error();
    }

}
