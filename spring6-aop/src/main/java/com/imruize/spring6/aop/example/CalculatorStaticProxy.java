package com.imruize.spring6.aop.example;

public class CalculatorStaticProxy implements Calculator{

    //被代理目标对象传递过来
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        //非核心功能
        System.out.println("[日志] add，");
        //调用目标对象方法
        int addResult = calculator.add(i, j);
        System.out.println("[日志] 结果，" + addResult);
        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
