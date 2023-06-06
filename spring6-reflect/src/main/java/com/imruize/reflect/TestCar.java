package com.imruize.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {

    //1. 获取class对象
    @Test
    public void test01() throws Exception {
        //1 类名.class
        Class<Car> clazz1 = Car.class;
        //2 对象.getClass()
        Class clazz2 =  new Car().getClass();
        //3 Class.forName("全路径")
        Class clazz3 = Class.forName("com.imruize.reflect.Car");
        //实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    //2. 获取构造方法
    @Test
    public void test02() throws Exception {
        Class<Car> clazz = Car.class;
        //获取所有构造
        // getConstructors()获取所有public构造方法
        // Constructor<?>[] constructors = clazz.getConstructors();
        // getDeclaredConstructors()获取所有构造方法
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c: constructors) {
            System.out.println(c.getName() + " " +c.getParameterCount());
        }

        // 指定有参构造创建对象
        //1 构造public
//        Constructor<Car> c1 = clazz.getConstructor(String.class, int.class, String.class);
//        Car car1 = c1.newInstance("Audi", 10, "red");
//        System.out.println(car1);
        //2 构造private
        Constructor<Car> c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);
        Car car2 = c2.newInstance("Tesla", 10, "red");
        System.out.println(car2);
    }

    //3. 获取属性
    @Test
    public void test03() throws Exception{
        Class<Car> carClass = Car.class;
        Car car = (Car) carClass.getDeclaredConstructor().newInstance();
        //获取所有public属性
        Field[] fields = carClass.getFields();
        //获取所有属性
        Field[] declaredFields = carClass.getDeclaredFields();
        for (Field field:declaredFields) {
            if (field.getName().equals("name")){
                //设置允许访问
                field.setAccessible(true);
                field.set(car, "Apple");
            }
            System.out.println(field.getName());
            System.out.println(car);
        }
    }

    //4. 获取方法
    @Test
    public void test04() throws Exception{
            Car car = new Car("google", 10, "black");
            Class<? extends Car> aClass = car.getClass();
            //1 public方法
            Method[] methods = aClass.getMethods();
        for (Method m1 :
                methods) {
//            System.out.println(m1.getName());
            //执行某方法
            if (m1.getName().equals("toString")){
                String invoke = (String) m1.invoke(car);
                System.out.println(invoke);
            }
        }
        //2 private方法
        Method[] methods1 = aClass.getDeclaredMethods();
        for (Method m1 :
                methods1) {
//            System.out.println(m1.getName());
            //执行某方法
            if (m1.getName().equals("run")){
                m1.setAccessible(true);
                m1.invoke(car);
            }
        }


    }
}
