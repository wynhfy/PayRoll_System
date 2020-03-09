package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.OverWorkInfo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OverWorkInfoDaoTest extends BaseTest {

    @Autowired
    private OverWorkInfoDao overWorkInfoDao;

    @Test
    public void Ainsert(){
        OverWorkInfo overWorkInfo=new OverWorkInfo();
        overWorkInfo.setOverWorkFee(1);
        overWorkInfo.setOverWorkId(1);
        int effectedNum=overWorkInfoDao.insertOverWorkInfo(overWorkInfo);
        assertEquals(1,effectedNum);
    }

    @Test
    public void Bupdate(){
        OverWorkInfo overWorkInfo=new OverWorkInfo();
        overWorkInfo.setOverWorkId(1);
        overWorkInfo.setOverWorkFee(2);
        int effectedNum=overWorkInfoDao.updateOverWorkInfo(overWorkInfo);
        assertEquals(1,effectedNum);
    }

    @Test
    public void Cquery(){
        OverWorkInfo overWorkInfo=overWorkInfoDao.queryOverWorkInfo(1);
        System.out.println(overWorkInfo.getOverWorkFee());
    }

    @Test
    public void Ddelete(){
        int effectedNum=overWorkInfoDao.deleteOverWorkInfo(1);
        assertEquals(1,effectedNum);
    }

}