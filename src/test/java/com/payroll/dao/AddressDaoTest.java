package com.payroll.dao;


import com.payroll.BaseTest;
import com.payroll.entity.Address;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class AddressDaoTest extends BaseTest {


    @Autowired
    private AddressDao addressDao;

    @Test
    public void insert(){
        Address address=new Address();
        address.setProvince("广东省");
        address.setCity("深圳市");
        address.setArea("福田区");
        address.setDetail("龙尾路星星花园");
        int effectedNum=addressDao.insertAddress(address);
        assertEquals(1,effectedNum);
    }

    @Test
    public void delete(){
        int effectedNum=addressDao.deleteAddress(1);
        assertEquals(1,effectedNum);
    }

    @Test
    public void query(){
        Address address=addressDao.queryAddressByAddressId(1);
        System.out.println(address);
    }

    @Test
    public void update(){
        Address address=new Address();
        address.setCity("广州市");
        address.setAddressId(1);
        int effectedNum=addressDao.updateAddress(address);
        assertEquals(1,effectedNum);
    }
}
