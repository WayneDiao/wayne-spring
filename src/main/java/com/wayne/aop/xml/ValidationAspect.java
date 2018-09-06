package com.wayne.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: wayne
 * @Date: 2018/9/6
 * @Description:
 */
public class ValidationAspect {
    public void validationArgs(JoinPoint point) {
        System.out.println("validate : " + Arrays.asList(point.getArgs()));
    }
}
