package com.payroll.dao;

import com.payroll.entity.OverWorkInfo;

public interface OverWorkInfoDao {

    public int insertOverWorkInfo(OverWorkInfo overWorkInfo);

    public int deleteOverWorkInfo(Integer overWorkId);

    public OverWorkInfo queryOverWorkInfo(Integer overWorkId);

    public int updateOverWorkInfo(OverWorkInfo overWorkInfo);
}
