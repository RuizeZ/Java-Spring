package com.imruize.spring6.iocxml.ditest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Department depart;
    private String name;
    private int age;

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    private String[] loves;
    public void work(){
        System.out.println("Employee: "+ name + " is working");
        depart.info();
        System.out.println(Arrays.toString(loves));
    }

    public Department getDepart() {
        return depart;
    }

    public void setDepart(Department depart) {
        this.depart = depart;
    }
}
