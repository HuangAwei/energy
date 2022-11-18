package com.tzh.energy.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzh.energy.entity.R;
import com.tzh.energy.entity.RiskHistory;
import com.tzh.energy.mapper.RiskHistoryMapper;
import com.tzh.energy.service.RiskHistoryService;
import com.tzh.energy.vo.RiskAssessmentVo;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
* @author hw
* @description 针对表【risk_history】的数据库操作Service实现
* @createDate 2022-11-14 14:28:28
*/
@Service
public class RiskHistoryServiceImpl extends ServiceImpl<RiskHistoryMapper, RiskHistory> implements RiskHistoryService {

    //一级风险权重
    public double[][] w = {{0.428}, {0.195}, {0.083}, {0.150}, {0.107}, {0.037}};
    //二级风险权重
    public double[][] w1 = {{0.638}, {0.211}, {0.151}};
    public double[][] w2 = {{0.483}, {0.336}, {0.181}};
    public double[][] w3 = {{0.231}, {0.183}, {0.586}};
    public double[][] w4 = {{0.452}, {0.328}, {0.220}};
    public double[][] w5 = {{0.303}, {0.417}, {0.142}, {0.138}};
    public double[][] w6 = {{0.415}, {0.389}, {0.196}};

    @Override
    public double riskAssessment(RiskAssessmentVo riskAssessmentVo) {
        R r = riskAssessmentVo.getR();
        double[][] b1 = matrixMultiplication(w1,r.getR1());
        double[][] b2 = matrixMultiplication(w2,r.getR2());
        double[][] b3 = matrixMultiplication(w3,r.getR3());
        double[][] b4 = matrixMultiplication(w4,r.getR4());
        double[][] b5 = matrixMultiplication(w5,r.getR5());
        double[][] b6 = matrixMultiplication(w6,r.getR6());
        double[][] bb = {
                getArray(b1),
                getArray(b2),
                getArray(b3),
                getArray(b4),
                getArray(b5),
                getArray(b6),
        };
        double[][] db = matrixMultiplication(w, bb);
        for (int i = 0; i < db.length; i++) {
            db[i][0] = fn(db[i][0],4);
        }
        double[] B= getArray(db);
        double level = normalizedColumn(B);
        RiskHistory riskHistory = new RiskHistory();
        riskHistory.setName(riskAssessmentVo.getName());
        riskHistory.setCoefficient(level +"");
        riskHistory.setR(JSON.toJSONString(r));
        save(riskHistory);
        return level;
    }

    @Override
    public Page<RiskHistory> energyTypePage(Map<String, Object> params) {
        int current = 1, size = 10;
        if (params.containsKey("current") && params.get("current") != ""){
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.containsKey("size") && params.get("size") != ""){
            size = Integer.parseInt((String) params.get("size"));
        }
        QueryWrapper<RiskHistory> wrapper = new QueryWrapper<>();
        if (params.containsKey("name") && params.get("name") != ""){
            wrapper.like("name",params.get("name"));
        }
        //分页对象
        Page<RiskHistory> page = new Page<>(current, size);
        page = this.page(page,wrapper);
        page.getRecords().forEach(item -> {
            item.setRr(JSON.parseObject(item.getR(), R.class));
            item.setR(null);
        });
        return page;
    }

    //矩阵乘法
    public double[][] matrixMultiplication(double[][] matrix1,double[][] matrix2) {
        Array2DRowRealMatrix realMatrix1 = new Array2DRowRealMatrix(matrix1);
        Array2DRowRealMatrix realMatrix2 = new Array2DRowRealMatrix(matrix2);
        RealMatrix transpose = realMatrix2.transpose();
        RealMatrix multiply = transpose.multiply(realMatrix1);
        return multiply.getData();
    }

    //二维数组转换一维数组
    public double[] getArray(double[][] d){
        double[] arr = new double[d.length];
        for (int i = 0; i < d.length; i++) {
            arr[i] = d[i][0];
        }
        return arr;
    }

    //保留n位小数
    public double fn(double d,int n){
        BigDecimal bg = new BigDecimal(d);
        return bg.setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //风险系数计算
    public double normalizedColumn(double[] matrix) {
        double level = 0;
        int j = 1;
        for (int i = 0; i < matrix.length; i++) {
            level += matrix[i] * j;
            j+=2;
        }
        return fn(level,2);
    }
}




