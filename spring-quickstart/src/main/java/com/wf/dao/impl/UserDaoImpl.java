package com.wf.dao.impl;


import java.util.*;

public class UserDaoImpl implements IUserDao {

    private String username;
    private  Integer age;

    private List<Object> list;
    private Set<Object> set;
    private  Object[] array;
    private Map<String,Object> map;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void init(){
        System.out.println("初始化方法执行了");
    }

    public void destory(){
        System.out.println("销毁方法执行了");
    }
    @Override
    public void save() {
        System.out.println("list集合"+list);
        System.out.println("set集合"+set);
        System.out.println("array数组"+ Arrays.toString(array));
        System.out.println("map集合"+map);
        System.out.println("property集合"+properties);
        System.out.println("dao被调用了......");
    }
}
