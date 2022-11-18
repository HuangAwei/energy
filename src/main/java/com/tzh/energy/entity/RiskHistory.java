package com.tzh.energy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName risk_history
 */
@TableName(value ="risk_history")
@Data
public class RiskHistory implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 风险系数
     */
    @TableField(value = "coefficient")
    private String coefficient;

    /**
     * 项目名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 
     */
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createDate;

    /**
     * 
     */
    @TableField(value = "R")
    private String r;

    /**
     *  风险指标专家评测表
     */
    @TableField(exist = false)
    private R rr;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}