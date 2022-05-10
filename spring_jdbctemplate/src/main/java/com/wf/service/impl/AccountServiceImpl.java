package com.wf.service.impl;

import com.wf.dao.AccountDao;
import com.wf.domain.Account;
import com.wf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findall() {

        /*return  accountDao.findall();*/
        /*List<Account> all = accountDao.findall();*/
        return  accountDao.findall();

    }

    @Override
    public Account findById(Integer id) {
        return  accountDao.findById(id);
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
    public void delete(Integer id) {
        accountDao.delete(id);
    }
}
