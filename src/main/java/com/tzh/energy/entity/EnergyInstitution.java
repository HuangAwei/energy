package com.tzh.energy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}