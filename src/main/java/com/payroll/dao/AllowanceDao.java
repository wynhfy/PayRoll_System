package com.payroll.dao;

import com.payroll.entity.Allowance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllowanceDao {

    public List<Allowance> queryById(Integer employeeId);

    public List<Allowance> queryByDate(@Param("year") int year,@Param("month") int month);

    public int deleteAllowance(Integer id);

    public int deleteAllowanceByEmployeeId(Integer employeeId);

}
