package com.wf.service.Impl;

import com.wf.service.AccountService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public void transfer() {
        System.out.println("转账方法执行啦1");
    }
}
