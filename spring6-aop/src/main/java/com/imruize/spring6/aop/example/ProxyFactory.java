package com.imruize.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理对象
    public Object getProxy(){
        /**
         * 1. ClassLoader: 加载动态生成代理类的类加载器
         * 2. interfaces: 目标对象实现的接口对象
         * 3. InvocationHandler: 设置代理对象设置目标对象的过程
         */
        ClassLoader classloader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandlernew = new InvocationHandler(){
            /**
             *
             * @param proxy the proxy instance that the method was invoked on
             *
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             *
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[日志]:" + method.getName());
                //调用目标方法
                Object invoke = method.invoke(target, args);

                System.out.println("[日志]" +  method.getName() + ":" + invoke);
                return invoke;
            }
        };
        return Proxy.newProxyInstance(classloader, interfaces, invocationHandlernew);
    }
}
