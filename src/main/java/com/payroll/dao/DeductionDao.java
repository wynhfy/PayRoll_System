package com.payroll.dao;

import com.payroll.entity.Deduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeductionDao {

    public List<Deduction> queryByEmployeeId(Integer employedId);

    public List<Deduction> queryByDate(@Param("year") int year,@Param("month") int month);

    public int deleteById(Integer id);

    public int deleteByEmployeeId(Integer employeeId);

}
