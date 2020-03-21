package com.payroll.service;

import com.payroll.entity.Employee;

import java.util.List;


public interface EmployeeService {


    public List<Employee> getEmployeeList();

    public int deleteEmployee(Integer employeeId);

    public Employee getEmployeeById(Integer employeeId);

    public int modifyEmployee(Employee employee);

}
