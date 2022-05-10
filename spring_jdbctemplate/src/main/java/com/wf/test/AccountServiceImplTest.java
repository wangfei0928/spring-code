package com.wf.test;

import com.wf.domain.Account;
import com.wf.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;

    /*添加*/
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("张飞");
        account.setMoney(1000d);
        accountService.save(account);
    }

    /*查询所有*/
    @Test
    public void testFindAll(){
        List<Account> all = accountService.findall();
        for (Account account : all) {
            System.out.println(account);
        }

    }

    /*通过id进行查询*/
    @Test
    public void testFindById() {
        Account account = accountService.findById(2);
        System.out.println(account);
    }
    /*修改*/
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setName("zm");
        account.setMoney(20d);
        account.setId(13);
        accountService.update(account);
    }
    /*删除操作*/
    @Test
    public void testDelete(){
        accountService.delete(14);
    }
}
