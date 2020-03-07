package com.payroll.dao;

import com.payroll.entity.LocalAccount;
import org.apache.ibatis.annotations.Param;

public interface LocalAccountDao {

    public LocalAccount queryByAccountAndPwd(@Param("account") int account,@Param("password") String password);

}
