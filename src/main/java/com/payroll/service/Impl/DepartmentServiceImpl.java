package com.payroll.service.Impl;

import com.payroll.dao.DepartmentDao;
import com.payroll.entity.Department;
import com.payroll.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 检查部门是否已经存在
     * @param name
     * @return
     */
    @Override
    public boolean checkDepartmentExist(String name) {
        Department department=departmentDao.queryDepartmentByName(name);
        if(department!=null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 插入一个部门
     * @param department
     * @return
     */
    @Override
    public boolean insertDepartment(Department department) {
        int effectedNum=departmentDao.insertDepartment(department);
        if(effectedNum==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 得到所有的部门信息
     * @return
     */
    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.queryAllDepartment();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentDao.queryDepartmentByName(name);
    }
}
