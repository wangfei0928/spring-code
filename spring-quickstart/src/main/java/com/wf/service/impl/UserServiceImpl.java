package com.wf.service.impl;

import com.wf.dao.impl.IUserDao;
import com.wf.service.IUserService;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;
/*
    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }*/

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
