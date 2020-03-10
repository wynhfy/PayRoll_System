package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.OverWork;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OverWorkDaoTest extends BaseTest {

    @Autowired
    private OverWorkDao overWorkDao;

    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void insert() throws ParseException {
        String start="2020-10-5 9:00:00";
        String end="2020-10-5 10:00:00";
        Date startTime=simpleDateFormat.parse(start);
        Date endTime=simpleDateFormat.parse(end);

        OverWork overWork=new OverWork();
        overWork.setEmployeeId(1);
        overWork.setOverWorkId(1);
        overWork.setStartTime(startTime);
        overWork.setEndTime(endTime);
        int effectedNum=overWorkDao.insertOverWork(overWork);
        assertEquals(1,effectedNum);
    }

    @Test
    public void query(){
        List<OverWork> list=overWorkDao.queryById(1);
        for(OverWork overWork:list){
            System.out.println(overWork);
        }
        list=overWorkDao.queryByDate("201910");
        for(OverWork overWork:list){
            System.out.println(overWork);
        }
    }



}