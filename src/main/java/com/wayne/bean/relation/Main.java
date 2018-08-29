package com.wayne.bean.relation;

import com.wayne.bean.autowire.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/28
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans-relation.xml");
        /*Address address = context.getBean("address",Address.class);
        System.out.println(address);*/

        Address address1 = context.getBean("address1",Address.class);
        System.out.println(address1);

        Address address2 = context.getBean("address2",Address.class);
        System.out.println(address2);
    }
}
