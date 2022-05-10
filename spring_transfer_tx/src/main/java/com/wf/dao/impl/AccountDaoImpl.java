package com.wf.dao.impl;

import com.wf.dao.AccountDao;
import com.wf.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String  outUser, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        jdbcTemplate.update(sql,money,outUser);
    }

    @Override
    public void in(String inUser, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        jdbcTemplate.update(sql,money,inUser);

    }
}
