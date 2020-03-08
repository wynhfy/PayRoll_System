package com.payroll.entity;

/**
 * 本地账号
 */
public class LocalAccount {

    private Integer employeeId;
    private String password;
    private int types;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "LocalAccount{" +
                "employeeId=" + employeeId +
                ", password='" + password + '\'' +
                ", type=" + types +
                '}';
    }
}
