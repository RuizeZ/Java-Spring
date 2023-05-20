package com.imruize.spring6.iocxml.ditest;

import java.util.List;

public class Department {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    private String name;
    private List<Employee> empList;
    public void info(){
        System.out.println("D name: " + name);
        for (Employee emp : empList) {
            System.out.println(emp.getName());
        }
    }
}
