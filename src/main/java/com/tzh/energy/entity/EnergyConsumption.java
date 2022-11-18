package com.tzh.energy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName energy_consumption
 */
@TableName(value ="energy_consumption")
@Data
public class EnergyConsumption implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "institution_id")
    private Integer institutionId;

    /**
     * 统计期内综合能耗，单位为千克标准煤每年（kgce/a）
     */
    @TableField(value = "e")
    private Double e;

    /**
     * 单位建筑面积综合能耗，单位为千克标准煤每平方米年（kgce/m2·a）
     */
    @TableField(value = "emz")
    private Double emz;

    /**
     * 单位建筑面积电耗，单位为千瓦时每平方米年（kW·h/m2·a）
     */
    @TableField(value = "emd")
    private Double emd;

    /**
     * 人均综合能耗，单位为千克标准煤每人年（kgce/per·a）
     */
    @TableField(value = "erz")
    private Double erz;

    /**
     * 建筑面积，单位为平方米（m2）
     */
    @TableField(value = "m")
    private Double m;

    /**
     * 统计期内电力消耗总量，单位为千瓦时每年（kW·h/a）
     */
    @TableField(value = "ed")
    private Double ed;

    /**
     * 总人数
     */
    @TableField(value = "n")
    private Integer n;

    /**
     * 年实际使用时间，单位为小时每年（h/a）
     */
    @TableField(value = "t")
    private Double t;

    /**
     * 住院人均住院部面积
     */
    @TableField(value = "q")
    private Double q;

    /**
     * 时间（统计年份）
     */
    @TableField(value = "date")
    private String date;

    /**
     * 创建时间
     */
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}