package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.Address;
import com.payroll.entity.Department;
import com.payroll.entity.Employee;
import com.payroll.entity.WorkType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeDaoTest  extends BaseTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private WorkTypeDao workTypeDao;

    @Test
    public void insert(){
        Department department=new Department();
        department.setDeptName("秘书部");
        department.setDeptAddress("三楼305");

        Address address=new Address();
        address.setProvince("广东省");
        address.setCity("深圳市");
        address.setArea("福田区");
        address.setDetail("星星花园");

        WorkType workType=new WorkType();
        workType.setWorkType("女秘书");
        workType.setGrade(1);
        workType.setBaseSalary(5000);

        departmentDao.insertDepartment(department);
        addressDao.insertAddress(address);
        workTypeDao.insertWorkType(workType);

        Employee employee=new Employee();
        employee.setName("aaa");
        employee.setAge("20");
        employee.setSex("男");
        employee.setNation("汉族");
        employee.setTelephone("13322983344");
        employee.setEmail("jwyn1999@Gmail.com");
        employee.setAcademic("本科");
        employee.setCreateTime(new Date());
        employee.setAddress(address);
        employee.setWorkType(workType);
        employee.setDepartment(department);
        int effectedNum=employeeDao.insertEmployee(employee);
        assertEquals(1,effectedNum);
    }

    @Test
    public void update(){
        Employee employee=new Employee();
        employee.setName("bbb");
        employee.setEmployeeId(1);
        int effectedNum=employeeDao.updateEmployee(employee);
        assertEquals(1,effectedNum);
    }

    @Test
    public void query(){
        Employee employee=new Employee();
        employee.setName("b");
        Employee queryemployee=employeeDao.queryEmployee(employee);
        System.out.println(queryemployee);
    }

    @Test
    public void delete(){

    }
}