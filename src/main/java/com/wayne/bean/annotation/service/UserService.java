package com.wayne.bean.annotation.service;

import com.wayne.bean.annotation.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    public void add() {
        System.out.println("UserService add.....");
        userRepository.save();
    }
}
