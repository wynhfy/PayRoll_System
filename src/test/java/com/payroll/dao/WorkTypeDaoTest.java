package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.WorkType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkTypeDaoTest extends BaseTest {

    @Autowired
    private WorkTypeDao workTypeDao;

    @Test
    public void insert(){
        WorkType workType=new WorkType();
        workType.setWorkType("经理");
        workType.setGrade(1);
        workType.setBaseSalary(10000);
        int effectedNum=workTypeDao.insertWorkType(workType);
        assertEquals(1,effectedNum);
    }

    @Test
    public void query(){
        WorkType workType=workTypeDao.queryWorkTypeById(1);
        System.out.println(workType);
    }

    @Test
    public void update(){
        WorkType workType=new WorkType();
        workType.setBaseSalary(5000);
        workType.setWorkTypeId(1);
        int effectedNum=workTypeDao.updateWorkType(workType);
        assertEquals(1,effectedNum);
    }

    @Test
    public void delete(){
        int effectedNum=workTypeDao.deleteWorkType(1);
        assertEquals(1,effectedNum);
    }

}