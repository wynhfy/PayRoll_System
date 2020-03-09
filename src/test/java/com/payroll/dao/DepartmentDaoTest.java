package com.payroll.dao;

import com.payroll.BaseTest;
import com.payroll.entity.Department;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest extends BaseTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void Ainsert(){
        Department department=new Department();
        department.setDeptName("秘书部");
        department.setDeptAddress("三楼401");
        int effectedNum=departmentDao.insertDepartment(department);
        assertEquals(1,effectedNum);
    }
    @Test
    public void Bquery(){
        Department department=departmentDao.queryDepartmentById(3);
        System.out.println(department);
        department=departmentDao.queryDepartmentByName("秘书部");
        assertEquals(new Integer(4),department.getDeptId());
    }

    @Test
    public void Cupdate(){
        Department department=new Department();
        department.setDeptAddress("二楼401");
        department.setDeptId(4);
        int effectedNum=departmentDao.updateDepartment(department);
        assertEquals(1,effectedNum);
    }

    @Test
    public void Ddelete(){
        int effectedNum=departmentDao.deleteDepartment(4);
        assertEquals(1,effectedNum);
    }
}