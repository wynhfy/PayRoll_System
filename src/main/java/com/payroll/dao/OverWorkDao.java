package com.payroll.dao;

import com.payroll.entity.OverWork;
import java.util.List;

public interface OverWorkDao {

     public int insertOverWork(OverWork overWork);

     public int deleteOverWork(Integer id);

    /**
     * 根据员工工号删除加班记录，用于删除员工的时候可以使用
     * @param employeeId
     * @return
     */
     public int deleteOverWorkByEmployeeId(Integer employeeId);

    /**
     * 根据工号查询加班记录
     * @param employeeId
     * @return
     */
     public List<OverWork> queryById(Integer employeeId);

    /**
     * 根据时间查询加班记录
     * @param datetime
     * @return
     */
     public List<OverWork> queryByDate(String datetime);

}
