package com.tzh.energy.entity;


import lombok.Data;

import java.io.Serializable;


//级风险指标专家评测
@Data
public class R implements Serializable {
    private double[][] r1;
    private double[][] r2;
    private double[][] r3;
    private double[][] r4;
    private double[][] r5;
    private double[][] r6;

    private static final long serialVersionUID = 1L;
}
