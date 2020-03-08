package com.payroll.entity;

import java.util.Date;

/**
 * 考勤表
 */
public class Attendance {

    private Integer id;
    private Integer employeeId;
    private Date arriveTime;  //到达时间

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

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }
}
