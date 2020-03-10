package com.payroll.entity;

/**
 * 扣费表，同时记录了考勤的天数
 */
public class Deduction {

    private Integer id;
    private Integer employeeId;
    private Integer yearNum;   //年份
    private Integer monthNum;  //月份
    private Integer totalDay;  //考勤的天数
    private double debit;      //扣的钱

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

    public Integer getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
        this.totalDay = totalDay;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    @Override
    public String toString() {
        return "Deduction{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", yearNum=" + yearNum +
                ", monthNum=" + monthNum +
                ", totalDay=" + totalDay +
                ", debit=" + debit +
                '}';
    }
}
