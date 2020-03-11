package com.payroll.dao;

import com.payroll.entity.Department;
import java.util.List;

public interface DepartmentDao {

    public int insertDepartment(Department department);

    public int deleteDepartment(Integer deptId);

    public Department queryDepartmentById(Integer deptId);

    public Department queryDepartmentByName(String deptName);

    public List<Department> queryAllDepartment();

    public int updateDepartment(Department department);


}
