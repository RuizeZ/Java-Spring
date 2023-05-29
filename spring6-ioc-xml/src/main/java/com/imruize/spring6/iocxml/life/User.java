package com.imruize.spring6.iocxml.life;

public class User {
    private String name;

    public User() {
        System.out.println("1. 调用无参构造");
    }

    //初始化方法
    public void initMethod(){
        System.out.println("4. bean对象初始化");
    }
    //销毁的方法
    public void destroy(){
        System.out.println("5. bean销毁对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. 注入属性");
        this.name = name;
    }

}
