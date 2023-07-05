package com.imruize.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//界面类
@Component //ioc容器中进行管理
public class LogAspect {
    //前置通知
    public void beforeMathod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Log-->前置通知 " + methodName + " 参数" + Arrays.toString(args));
    }
    // 后置通知
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Log-->后置通知 " + methodName);
    }

    //返回通知
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Log-->返回通知, 返回值: " + result);
    }

    //异常通知
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable err){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Log-->异常通知, 返回值: " + err);
    }

    //环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前");
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后 result: " + result);
        }catch (Throwable err){
            err.printStackTrace();
            System.out.println("环绕通知==目标方法异常");
        }finally {
            System.out.println("环绕通知==目标方法最后");
        }
        return result;
    }

    //重用接入点表达式
    @Pointcut(value = "execution(* com.imruize.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void pointCut(){}
}
