package com.tzh.energy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 设备
 * @TableName device
 */
@TableName(value ="device")
@Data
public class Device implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 设备类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 创建时间
     */
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @TableField(value = "update_date",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime updateDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}