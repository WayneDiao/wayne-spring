package com.wayne.bean.annotation;

import com.wayne.bean.annotation.controller.UserController;
import com.wayne.bean.annotation.repository.UserRepository;
import com.wayne.bean.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean/beans-annotation.xml");
        TestObject testObject = context.getBean(TestObject.class);
        System.out.println(testObject);

        UserRepository userRepository = context.getBean(UserRepository.class);
        System.out.println(userRepository);

        UserController userController = context.getBean(UserController.class);
        System.out.println(userController);
        userController.execute();

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);


    }
}
