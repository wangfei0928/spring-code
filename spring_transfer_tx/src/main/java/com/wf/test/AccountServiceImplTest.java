package com.wf.test;


import com.wf.config.SpringConfig;
import com.wf.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration("classpath:applicationContext.xml")*/
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("tom","jerry",100d);
    }


}
