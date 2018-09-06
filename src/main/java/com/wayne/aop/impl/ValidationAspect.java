package com.wayne.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: wayne
 * @Date: 2018/9/6
 * @Description:    使用@Order注解指定切面的优先级，值越小优先级越高
 */
@Order(1)
@Component
@Aspect
public class ValidationAspect {
    @Before("LoggingAspect.declareJoinPointExpression()")
    public void validationArgs(JoinPoint point) {
        System.out.println("validate : " + Arrays.asList(point.getArgs()));
    }
}
