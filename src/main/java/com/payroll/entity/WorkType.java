package com.payroll.entity;

/**
 * 工种表
 */
public class WorkType {

    private Integer workTypeId;
    private String workType; //职业
    private Integer grade;   //等级
    private double baseSalary; //基础工资

    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
