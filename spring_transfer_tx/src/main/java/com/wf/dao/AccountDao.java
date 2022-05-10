package com.wf.dao;

import com.wf.domain.Account;

public interface AccountDao {
    public void out(String outUser,Double money);

    public void in(String inUser,Double money);

}
