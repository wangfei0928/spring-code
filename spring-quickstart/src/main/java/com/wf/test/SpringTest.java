package com.wf.test;

import com.wf.dao.impl.IUserDao;
import com.wf.service.IUserService;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {

    @Test
    public void test1(){
        //获取到了Spring上下文对象，借助上下文对象可以获取到IOC容器中bean对象。
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用上下文对象从IOC容器中获取到bean对象。
        //1. 根据beanid在容器中的找对应的bean对象
//        IUserDao userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        //2. 根据类型在在容器中进行查询：有可能报错的可能：当前匹配到多个实例
        IUserDao  userDao = classPathXmlApplicationContext.getBean("userDao",IUserDao.class);

        //调用方法
        userDao.save();
    }

    @Test
    public void test2(){
       BeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
       IUserDao userDao = (IUserDao)xmlBeanFactory.getBean("userDao");
        userDao.save();
    }


    //测试scope属性，singletion效果
    @Test
    public void test3(){
        //获取到了Spring上下文对象，借助上下文对象可以获取到IOC容器中bean对象。
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        IUserDao  userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        IUserDao  userDao2 = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        System.out.println(userDao);
        System.out.println(userDao2);
    }

    //测试scope属性，prototype效果
    @Test
    public void test4(){
        //获取到了Spring上下文对象，借助上下文对象可以获取到IOC容器中bean对象。
        ApplicationContext classPathXmlpplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        IUserDao  userDao = (IUserDao) classPathXmlpplicationContext.getBean("userDao");

        IUserDao  userDao2 = (IUserDao) classPathXmlpplicationContext.getBean("userDao");

        System.out.println(userDao);
        System.out.println(userDao2);
    }
    @Test
    public void test5(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = (IUserService)classPathXmlApplicationContext.getBean("userService");
        userService.save();

    }

}
