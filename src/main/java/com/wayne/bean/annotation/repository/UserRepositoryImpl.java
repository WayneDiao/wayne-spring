package com.wayne.bean.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    public void save() {
        System.out.println("UserRepository save.....");
    }
}
