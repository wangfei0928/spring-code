package com.wf.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class Myadvice {
    public void before(){

        System.out.println("前置方法执行了！");
    }

    public void afterReturning(){
        System.out.println("后置方法执行了1");
    }
    public void thread(){
        System.out.println("异常方法执行啦");
    }
    public void result(){
        System.out.println("最终方法执行了");
    }

    //环绕通知
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {

        Object proceed = null;
        try {
            System.out.println("前置通知执行了");
            proceed = proceedingJoinPoint.proceed();
            System.out.println("后置通知执行了");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("异常通知执行了");
        } finally {
            System.out.println("最终方法执行了");
        }
        return proceed;
    }




}
