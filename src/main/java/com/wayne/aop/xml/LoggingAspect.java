package com.wayne.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wayne
 * @Date: 2018/9/5
 * @Description:
 */

public class LoggingAspect {



    public void beforeMethod(JoinPoint point) {
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("The Method " + methodName + " begins with " + args);
    }

    public void afterMethod(JoinPoint point) {
        String methodName = point.getSignature().getName();
        System.out.println("The Method " + methodName + " ends");
    }

    public void returnMethod(JoinPoint point, Object result) {
        String methodName = point.getSignature().getName();
        System.out.println("The Method " + methodName + " ends with " + result);
    }

    public void throwMethod(JoinPoint point, Exception result) {
        String methodName = point.getSignature().getName();
        System.out.println("The Method " + methodName + " ends with " + result);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String name = proceedingJoinPoint.getSignature().getName();
        try {
            System.out.println("The method " + name + " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            System.out.println("The method " + name + " ends with " + result);
        } catch (Throwable throwable) {
            System.out.println("The method " + name + " is exception");
            throwable.printStackTrace();
        }
        return result;
    }
}
