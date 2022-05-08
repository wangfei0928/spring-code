package com.wf.proxy;

import com.wf.service.AccountService;
import com.wf.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/*
* JDK 动态代理工厂类
* */
@Component
public class JDKProxyFactory {

    @Autowired
    private TransactionManager transactionManager;

    @Autowired
    private AccountService accountService;

      /*
            采用JDK动态代理技术来生成目标动态代理对象
            ClassLoader Loader： 类加载器：借助被代理对象获取到类加载器
             Class<?>[] interfaces: 被代理对象所需要实现的全部接口
             InvocationHandler h: 当代理对象调用接口中的任意方法时，都会执行InvocationHandler中的invoke方法
       */


    public AccountService creatAccountServiceJDKProxy(){
        //proxy:当前代理对象引用， method：被调用的目标方法引用 args:被调用的目标方法参数
        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass()
                .getClassLoader(), accountService.getClass().getInterfaces(), (proxy, method, args) -> {
                    //让被代理对象的原方法执行
                    try {
                        //手动开启事务
                        transactionManager.beginTransaction();
                        //业务操作
                         method.invoke(accountService, args);
                        //手动关闭事务
                        transactionManager.commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        //手动事务回滚
                        transactionManager.roolback();
                    }finally {

                    //手动关闭事务
                    transactionManager.release();
                }

                    return null;
                });

        return  accountServiceProxy;

    }
}
