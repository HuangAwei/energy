package com.tzh.energy.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EnergyConsumptionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //机构id
    private Integer institutionId;

    //统计时间
    private String date;

    //面积
    private Double m;

    //电力消耗
    private Double ed;

    //人数
    private Integer n;

    //年使用时间
    private Double t;

    //住院人均住院部面积
    private Double q;

    //消耗能源种类及用量列表
    private List<Energy> energyList;
}

