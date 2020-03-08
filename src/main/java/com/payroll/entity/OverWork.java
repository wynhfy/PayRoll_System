package com.payroll.entity;

import java.util.Date;

/**
 * 加班表
 */
public class OverWork {

    private Integer id;
    private Integer employeeId;
    private Date startTime;  //加班开始时间
    private Date endTime;    //加班结束时间
    private Integer overWorkId; //加班类别

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOverWorkId() {
        return overWorkId;
    }

    public void setOverWorkId(Integer overWorkId) {
        this.overWorkId = overWorkId;
    }
}
