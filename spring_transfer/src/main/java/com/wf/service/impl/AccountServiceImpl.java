package com.wf.service.impl;

import com.wf.dao.AccountDao;
import com.wf.service.AccountService;
import com.wf.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;



    /*
    * 转账方法     切入点， 添加上事物的效果
    * */
    @Override
    public void transfer(String outUser, String inUser, Double money) {


        //调用了减钱方法
        accountDao.out(outUser, money);
        /* int i = 1/0;*/
        //调用了加钱方法
        accountDao.in(inUser, money);
    }


}
