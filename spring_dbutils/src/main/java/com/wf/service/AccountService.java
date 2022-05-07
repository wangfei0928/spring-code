package com.wf.service;

import com.wf.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();
    public Account findById(int id);

    public  void save(Account account) ;
    public void update(Account account);

    public void delete( int id);

}
