package com.wf.factory;

import com.wf.dao.impl.IUserDao;
import com.wf.dao.impl.UserDaoImpl;

public class DynamicFactoryBean {

    public IUserDao createUserDao(){
        return  new UserDaoImpl();
    }
}
