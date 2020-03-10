package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.Allowance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.junit.Assert.*;

public class AllowanceDaoTest extends BaseTest {

    @Autowired
    private AllowanceDao allowanceDao;

    @Test
    public void insert(){
        List<Allowance> list=allowanceDao.queryById(1);
        for(Allowance allowance:list){
            System.out.println(allowance);
        }

        list=allowanceDao.queryByDate(2020,10);
        for (Allowance allowance:list){
            System.out.println(allowance);
        }
    }

}