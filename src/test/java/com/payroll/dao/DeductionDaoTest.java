package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.Deduction;
import org.junit.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DeductionDaoTest extends BaseTest {

    @Autowired
    private DeductionDao deductionDao;

    @Test
    public void query(){
        List<Deduction> list=deductionDao.queryByEmployeeId(1);
        for(Deduction deduction:list){
            System.out.println(deduction);
        }
        list=deductionDao.queryByDate(2019,10);
        for(Deduction deduction:list){
            System.out.println(deduction);
        }
    }

}