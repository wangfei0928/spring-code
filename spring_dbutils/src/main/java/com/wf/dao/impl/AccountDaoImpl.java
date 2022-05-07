package com.wf.dao.impl;

import com.wf.dao.AccountDao;
import com.wf.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    public QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() {

        List<Account> list = null;
        //编写sql
        String sql = "select * from account";
        try {
            list = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        //编写sql
        String sql = "select * from account where id = ?";
        try {
            account = queryRunner.query(sql, new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void save(Account account) {
        String sql = "insert into account values(null,?,?)";
        try {
            queryRunner.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Account account) {
        String sql = "update account set name = ?, money = ? where id = ?";
        try {
            queryRunner.update(sql,account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from account where id = ?";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
