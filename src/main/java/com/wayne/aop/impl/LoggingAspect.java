package com.wayne.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wayne
 * @Date: 2018/9/5
 * @Description: 把这个类声明为一个切面：把类放入容器中，再声明为一个切面
 */
@Aspect
@Component
public class LoggingAspect {

    /*声明该方法时一个前置通知:再目标方法之前执行*/
    @Before("execution(public Integer com.wayne.aop.impl.CalcService.*(..))")
    public void beforeMethod(JoinPoint point) {
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("The Method " + methodName + " begins with " + args);
    }

    /*后置通知：目标方法执行后执行(无论是否发生异常)*/
    /*在后置通知中还不能访问目标方法的结果*/
    @After("execution(public Integer com.wayne.aop.impl.CalcService.*(Integer,Integer))")
    public void afterMethod(JoinPoint point) {
        String methodName = point.getSignature().getName();
        System.out.println("The Method " + methodName + " ends");
    }

    /*正常返回结果后执行*/
    @AfterReturning(value = "execution(public Integer com.wayne.aop.impl.CalcService.*(Integer,Integer))", returning = "result")
    public void returnMethod(JoinPoint point, Object result) {
        String methodName = point.getSignature().getName();
        System.out.println("The Method " + methodName + " ends with " + result);
    }

    /*出现指定异常时执行*/
    @AfterThrowing(value = "execution(public Integer com.wayne.aop.impl.CalcService.*(Integer,Integer))", throwing = "result")
    public void throwMethod(JoinPoint point, Exception result) {
        String methodName = point.getSignature().getName();
        System.out.println("The Method " + methodName + " ends with " + result);
    }

    /*
     * 环绕通知需要携带ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint这个类型的参数可以决定是否决定执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     */
    @Around("execution(public Integer com.wayne.aop.impl.CalcService.*(Integer,Integer))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String name = proceedingJoinPoint.getSignature().getName();
        try {
            /*前置通知*/
            System.out.println("The method " + name + " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            /*返回通知*/
            System.out.println("The method " + name + " ends with " + result);
        } catch (Throwable throwable) {
            /*异常通知*/
            System.out.println("The method " + name + " is exception");
            throwable.printStackTrace();
        }
        return result;
    }
}
