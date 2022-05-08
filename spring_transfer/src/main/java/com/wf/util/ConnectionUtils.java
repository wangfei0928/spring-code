package com.wf.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
* 连接数据类：从数据源中获取一个连接，并且将获取到的连接与线程进行绑定
* */
@Component
public class ConnectionUtils {


    @Autowired
    private DataSource dateSourse;
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /*
    * 获取当前线程的连接，如果获取到的连接为空，就要从数据源中获取连接，并且放到ThreadLocal中
     */
    public Connection getThreadConnection(){
       Connection connection = threadLocal. get();
       if (connection == null){
           try {
               connection = dateSourse.getConnection();
               threadLocal.set(connection);

           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
       }
        return connection;
    }

    public void removeThreadConnection(){
        threadLocal.remove();
    }
}
