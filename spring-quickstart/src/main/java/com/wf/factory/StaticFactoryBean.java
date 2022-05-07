package com.wf.factory;

import com.wf.dao.impl.IUserDao;
import com.wf.dao.impl.UserDaoImpl;

public class StaticFactoryBean {

    public static IUserDao creatUserDao(){



        return  new UserDaoImpl();
    }


}
