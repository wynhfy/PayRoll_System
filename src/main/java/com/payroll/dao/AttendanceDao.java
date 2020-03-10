package com.payroll.dao;

import com.payroll.entity.Attendance;
import java.util.List;

public interface AttendanceDao {

    public int insertAttendance(Attendance attendance);

    public int deleteAttendance(Integer id);

    public int deleteAttendanceByEmployeeId(Integer employeeId);

    /**
     * 根据工号查询考勤记录
     * @param employeeId
     * @return
     */
    public List<Attendance> queryById(Integer employeeId);

    /**
     * 根据时间查询考勤记录
     * @param datetime
     * @return
     */
    public List<Attendance> queryByDate(String datetime);


}
