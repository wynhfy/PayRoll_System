package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.Attendance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.junit.Assert.*;

public class AttendanceDaoTest  extends BaseTest {

    @Autowired
    private AttendanceDao attendanceDao;

    @Test
    public void query(){
        List<Attendance> list=attendanceDao.queryByDate("201910");
        for(Attendance attendance:list){
            System.out.println(attendance);
        }
    }

}