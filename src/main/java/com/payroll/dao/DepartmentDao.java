package com.payroll.dao;

import com.payroll.entity.Department;

public interface DepartmentDao {

    public int insertDepartment(Department department);

    public int deleteDepartment(Integer deptId);

    public Department queryDepartmentById(Integer deptId);

    public Department queryDepartmentByName(String deptName);

    public int updateDepartment(Department department);


}
