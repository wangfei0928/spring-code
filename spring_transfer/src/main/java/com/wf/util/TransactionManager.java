package com.wf.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component("transactionManager")
public class TransactionManager {
    /*
    * 开启事务
    * */
    @Autowired
    private ConnectionUtils connectionUtils;
    public void beginTransaction(){

        //获取connection对象
        Connection connection = connectionUtils.getThreadConnection();
        try {
            //开启手动提交事务，关机自动提交
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    * 提交事务
    * */
    public void commit(){
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * 回滚事务*/
    public  void roolback(){
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*释放资源*/
    public void release(){
        //将手动改为自动提交事务
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.setAutoCommit(true);
            //将连接归还到连接池
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeThreadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
