package com.tzh.energy.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
//自动填充创建时间、更新时间字段

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //使用mp进行添加操作这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate",LocalDateTime.now(),metaObject);
    }

    //使用mp进行修改操作这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateData",LocalDateTime.now(),metaObject);
    }
}

