package com.payroll.entity;

/**
 * 加班表
 */
public class Allowance {

    private Integer id;
    private Integer employeeId;
    private Integer overTime;  //加班总时长
    private Integer overDay;   //加班总天数
    private double benefitSalary; //加班总津贴
    private Integer yearNum;      //年
    private Integer monthNum;     //月

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public Integer getOverDay() {
        return overDay;
    }

    public void setOverDay(Integer overDay) {
        this.overDay = overDay;
    }

    public Double getBenefitSalary() {
        return benefitSalary;
    }

    public void setBenefitSalary(Double benefitSalary) {
        this.benefitSalary = benefitSalary;
    }

    public Integer getYearNum() {
        return yearNum;
    }

    public void setYearNum(Integer yearNum) {
        this.yearNum = yearNum;
    }

    public Integer getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(Integer monthNum) {
        this.monthNum = monthNum;
    }

    @Override
    public String toString() {
        return "Allowance{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", overTime=" + overTime +
                ", overDay=" + overDay +
                ", benefitSalary=" + benefitSalary +
                ", yearNum=" + yearNum +
                ", monthNum=" + monthNum +
                '}';
    }
}
