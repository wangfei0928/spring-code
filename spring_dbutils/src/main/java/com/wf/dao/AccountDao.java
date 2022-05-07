package com.wf.dao;

import com.wf.domain.Account;

import java.util.List;

public interface AccountDao {

    public List<Account>  findAll();
    public Account findById( int id);

    public  void save(Account account) ;
    public void update(Account account);

    public void delete( int id);

}
