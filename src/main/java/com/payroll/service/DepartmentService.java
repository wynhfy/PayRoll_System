package com.payroll.service;

import com.payroll.entity.Department;
import java.util.List;

public interface DepartmentService {


    public boolean checkDepartmentExist(String name);

    public boolean insertDepartment(Department department);

    public List<Department> getDepartmentList();

    public Department getDepartmentByName(String name);

    public boolean deleteDepartment(Department department);

    public boolean updateDepartment(Department department);

}
