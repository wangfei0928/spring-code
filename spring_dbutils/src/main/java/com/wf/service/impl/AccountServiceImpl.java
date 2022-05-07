package com.wf.service.impl;

import com.wf.dao.AccountDao;
import com.wf.domain.Account;
import com.wf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("accountService")  //相当于配置了bean标签   id属性  class属性
public class AccountServiceImpl implements AccountService {

  @Autowired  //根据类型进行注入
  @Qualifier("accountDao")

   private AccountDao accountDao;
  @Value("注入普通注入")
  private String str;

  @Value("${jdbc.driverClassName}")
  private String driver;
/*
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/

    @Override
    public List<Account> findAll() {
        System.out.println(driver);
        System.out.println(str);
        List<Account> all = accountDao.findAll();
        return all;
    }

    @Override
    public Account findById(int id) {
        Account byId = accountDao.findById(id);
        return byId;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(int id) {
        accountDao.delete(id);
    }
}
