package com.wayne.aop.review;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: wayne
 * @Date: 2018/9/11
 * @Description:
 */
@Component
@org.aspectj.lang.annotation.Aspect
@Order(1)
public class Aspect {
    @Pointcut(value = "execution(* com.wayne.aop.review.Demo.*(String,Integer))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint point) {
        Object[] strings = point.getArgs();
        String method = point.getSignature().getName();
        System.out.println(method + " start with " + Arrays.asList(strings));

    }

}
