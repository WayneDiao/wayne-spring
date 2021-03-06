package com.wayne.bean.annotation.controller;

import com.wayne.bean.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public void execute() {
        System.out.println("UserController execute....");
        userService.add();
    }
}
