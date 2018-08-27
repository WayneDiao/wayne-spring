package com.wayne.main;

import com.wayne.bean.B;
import com.wayne.bean.Person;
import com.wayne.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/27
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");

        User user = (User) context.getBean("hello");
        System.out.println(user.toString());

        User user1 = context.getBean(User.class);
        System.out.println(user1.toString());

        User user2 = context.getBean("hello",User.class);
        System.out.println(user2.toString());

        B b = (B) context.getBean("b");
        System.out.println(b.toString());

        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
