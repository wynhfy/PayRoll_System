package com.payroll.dao;

import com.payroll.entity.Address;

public interface AddressDao {

    /**
     * 插入一个地址
     * @param address
     * @return
     */
    public int insertAddress(Address address);

    /**
     * 根据addressId删除一个地址
     * @param addressId
     * @return
     */
    public int deleteAddress(Integer addressId);


    /**
     * 根据addressId查询用户地址
     * @param addressId
     * @return
     */
    public Address queryAddressByAddressId(Integer addressId);


    /**
     * 更新用户地址
     * @param address
     * @return
     */
    public int updateAddress(Address address);

}
