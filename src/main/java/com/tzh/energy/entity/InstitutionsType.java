package com.tzh.energy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName institutions_type
 */
@TableName(value ="institutions_type")
@Data
public class InstitutionsType implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 机构类型名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 年使用时间
     */
    @TableField(value = "T0")
    private Integer t0;

    /**
     * 人均建筑面积
     */
    @TableField(value = "S0")
    private Integer s0;

    /**
     * 住院人均住院部面积
     */
    @TableField(value = "Q0")
    private Integer q0;

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