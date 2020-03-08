package com.payroll.entity;

/**
 * 月工资表
 */
public class monthSalary {

    private Integer id;
    private Integer employeeId;
    private String name;
    private double baseSalary;  //基础工资
    private double addSalary;   //加班工资
    private double decSalary;   //扣费
    private double totalSalary; //总工资
    private Integer yearNum;
    private Integer monthNum;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getAddSalary() {
        return addSalary;
    }

    public void setAddSalary(double addSalary) {
        this.addSalary = addSalary;
    }

    public double getDecSalary() {
        return decSalary;
    }

    public void setDecSalary(double decSalary) {
        this.decSalary = decSalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
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
}
