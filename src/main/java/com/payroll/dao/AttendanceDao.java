package com.payroll.dao;

import com.payroll.entity.Attendance;
import java.util.List;

public interface AttendanceDao {

    public int insertAttendance(Attendance attendance);

    public List<Attendance> queryById(Integer employeeId);

    public List<Attendance> queryByDate(String datetime);


}
