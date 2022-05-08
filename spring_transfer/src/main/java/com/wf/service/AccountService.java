package com.wf.service;

import org.springframework.beans.factory.annotation.Autowired;

public interface AccountService {


    //转账方法
    public void transfer(String outUser,String inUser,Double money);

}
