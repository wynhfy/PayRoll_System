package com.payroll.service.Impl;

import com.payroll.service.LocalAccountService;
import com.payroll.dao.LocalAccountDao;
import com.payroll.entity.LocalAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalAccountServiceImpl implements LocalAccountService {

    @Autowired
    private LocalAccountDao localAccountDao;


    @Override
    public int loginCheck(int account,String password) {
        LocalAccount localAccount =localAccountDao.queryByAccountAndPwd(account,password);
        if(localAccount!=null && localAccount.getTypes()==1){
            return 1;
        }else if(localAccount!=null && localAccount.getTypes()==0){
            return 0;
        }else{
            return -1;
        }
    }
}
