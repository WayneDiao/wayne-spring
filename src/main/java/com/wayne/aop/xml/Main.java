package com.wayne.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/9/5
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/application-xml.xml");


        CalcService service = context.getBean(CalcService.class);

        int result = service.add(3, 6);
        System.out.println("result: " + result);

        result = service.div(6, 1);
        System.out.println("result: " + result);
    }
}
