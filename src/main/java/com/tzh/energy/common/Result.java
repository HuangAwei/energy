package com.tzh.energy.common;

import lombok.Data;

//统一返回结果
@Data
public class Result<T> {
    //是否成功
    private Boolean success;

    //返回消息
    private String message;

    //返回数据
    private T data;

    //构造器私有化
    private Result() {
    }


    //成功静态方法
    public static Result success() {
        Result r = new Result();
        r.setSuccess(true);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static Result error() {
        Result r = new Result();
        r.setSuccess(false);
        r.setMessage("失败");
        return r;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result data(T data) {
        this.data = data;
        return this;
    }
}
