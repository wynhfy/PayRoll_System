package com.payroll.dao;

import com.payroll.entity.WorkType;

public interface WorkTypeDao {

    public int insertWorkType(WorkType workType);

    public int deleteWorkType(Integer workTypeId);

    public WorkType queryWorkTypeById(Integer workTypeId);

    public int updateWorkType(WorkType workType);

}
