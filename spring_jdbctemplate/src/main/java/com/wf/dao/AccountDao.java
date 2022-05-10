package com.wf.dao;

import com.wf.domain.Account;

import java.util.LinkedList;
import java.util.List;

public interface AccountDao {

    /*查询所有用户*/
    public List<Account> findall();



    /*通过id查询用户*/
    public Account findById(Integer id);

    /*添加用户*/
    public void save(Account account);

    /*修改用户*/
    public void  update(Account account);

    /*删除用户*/
    public void  delete(Integer id);
}
