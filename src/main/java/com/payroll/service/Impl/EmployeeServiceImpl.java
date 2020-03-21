package com.payroll.service.Impl;

import com.payroll.dao.EmployeeDao;
import com.payroll.entity.Employee;
import com.payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeDao.queryAllEmployee();
    }

    @Override
    public int deleteEmployee(Integer employeeId) {
        return employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeDao.queryByEmployeeId(employeeId);
    }

    @Override
    public int modifyEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }
}
