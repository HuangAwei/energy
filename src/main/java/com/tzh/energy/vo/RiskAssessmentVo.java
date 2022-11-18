package com.tzh.energy.vo;

import com.tzh.energy.entity.R;
import lombok.Data;

import java.io.Serializable;


@Data
public class RiskAssessmentVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private R r;
}
