package com.tzh.energy.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Energy implements Serializable {
    private static final long serialVersionUID = 1L;

    //能源id
    private Integer energyId;

    //能源用量
    private Double value;
}
