package com.tzh.energy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName energy_institution
 */
@TableName(value ="energy_institution")
@Data
public class EnergyInstitution implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "energy_id")
    private Integer energyId;

    /**
     * 
     */
    @TableField(value = "institution_id")
    private Integer institutionId;

    /**
     * 消耗量
     */
    @TableField(value = "value")
    private Double value;


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