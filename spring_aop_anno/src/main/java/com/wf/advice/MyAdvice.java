package com.wf.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(public void com.wf.service.Impl.AccountServiceImpl.transfer())")
    public void myPoint(){}

   /*@Before("MyAdvice.myPoint()")
    public void before(){
        System.out.println("前置方法执行了");
    }
    @AfterReturning("MyAdvice.myPoint()")
    public void afterReturning(){
        System.out.println("后置方法执行了");
    }

    @After("MyAdvice.myPoint()")
    public void after(){
        System.out.println("最后方法执行了");
    }

    @AfterThrowing("MyAdvice.myPoint()")
    public void throwing(){
        System.out.println("异常方法执行了");
    }*/


    @Around("MyAdvice.myPoint()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object proceed = null;


        try {
            System.out.println("前置方法执行了");
            proceed = proceedingJoinPoint.proceed();
            System.out.println("后置方法执行了");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("异常方法执行了");
        }finally {
            System.out.println("最后方法执行了");
        }
        return proceed;

    }
}
