package com.payroll.dao;

import com.payroll.entity.MonthSalary;
import java.util.List;

public interface MonthSalaryDao {

    public int insertMonthSalary(MonthSalary monthSalary);

    public int deleteByEmployeeId(Integer employeeId);

    public List<MonthSalary> queryMonthSalary(MonthSalary monthSalary);


}
