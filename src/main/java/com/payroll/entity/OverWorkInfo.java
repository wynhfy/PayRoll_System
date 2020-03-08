package com.payroll.entity;

/**
 * 加班类别表
 */
public class OverWorkInfo {

    private Integer overWorkId; //加班类别
    private double overWorkFee; //加班费用,按分钟计算

    public Integer getOverWorkId() {
        return overWorkId;
    }

    public void setOverWorkId(Integer overWorkId) {
        this.overWorkId = overWorkId;
    }

    public double getOverWorkFee() {
        return overWorkFee;
    }

    public void setOverWorkFee(double overWorkFee) {
        this.overWorkFee = overWorkFee;
    }
}
