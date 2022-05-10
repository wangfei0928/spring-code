package com.wf.dao.impl;

import com.wf.dao.AccountDao;
import com.wf.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /*
    * 查询所有用户
    * */
    @Override
    public List<Account> findall() {
        //需要用到JdbcTemplate
        String sql ="select * from account";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        return list;
    }

    /*
    * 通过ID查询用户
    * */
    @Override
    public Account findById(Integer id) {
        String sql = "select * from account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class),id);
        return account;
    }

    /*
    * 添加用户
    * */
    @Override
    public void save(Account account) {
        String sql = "insert into account values(null,?,?) ";
        jdbcTemplate.update(sql,account.getName(),account.getMoney());
    }

    /*
    * 修改用户
    * */
    @Override
    public void update(Account account) {
        String sql = "update account set name = ? ,money = ? where id = ?";
        jdbcTemplate.update(sql,account.getName(),account.getMoney(),account.getId());
    }


    /*
    * 删除用户
    * */
    @Override
    public void delete(Integer id) {
        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
