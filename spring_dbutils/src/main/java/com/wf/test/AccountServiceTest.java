package com.wf.test;

import com.wf.domain.Account;
import com.wf.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");

    //测试添加
    @Test
    public void testSave(){

        Account account = new Account();
        account.setName("lucy");
        account.setMoney(8888);
        accountService.save(account);
    }

    //测试查询
    @Test
    public void testfindByid(){
        Account account = accountService.findById(3);
        System.out.println(account);
    }

    //测试查询所有
    @Test
    public void testFindAll(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    //更新测试
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(3);
        account.setName("jack");
        account.setMoney(2000);

        accountService.update(account);
    }

    @Test
    public void testDelete(){
        accountService.delete(3);
    }

}
