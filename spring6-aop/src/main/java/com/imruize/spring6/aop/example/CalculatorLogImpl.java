package com.imruize.spring6.aop.example;

public class CalculatorLogImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add，");
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] 结果，");
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub，");
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] 结果，");
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul，");
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] 结果，");
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div ，");
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] 结果，");
        return result;
    }
}
