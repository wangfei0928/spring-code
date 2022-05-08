package com.wf.test;

import com.wf.proxy.JDKProxyFactory;
import com.wf.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JDKProxyFactory ProxyFactory;

    @Test
    public void testTransfer(){
        accountService.transfer("tom","jerry",100d);
    }

    @Test
    public void testTransferProxy(){


        //当前返回的实际上是AccountService的代理雪乡Proxy
        AccountService accountServiceJDKProxy = ProxyFactory.creatAccountServiceJDKProxy();
        //代理对象proxy调用接口中的任意方法时，都会执行底层的invoke方法
        accountServiceJDKProxy.transfer("tom","jerry",100d);
    }




}
