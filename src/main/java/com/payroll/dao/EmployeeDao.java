package com.payroll.dao;

import com.payroll.entity.Employee;
import java.util.List;

public interface EmployeeDao {

    public int insertEmployee(Employee employee);

    public int deleteEmployee(Integer employeeId);

    public Employee queryEmployee(Employee employee);

    public List<Employee> queryAllEmployee();

    public int updateEmployee(Employee employee);



    /**
     * 根据部门id查询员工
     * @param deptId
     * @return
     */
    public List<Employee> queryEmployeeList(Integer deptId);

    /**
     * 根据工号查询员工id
     * @param employeeId
     * @return
     */
    public Employee queryByEmployeeId(Integer employeeId);

}
