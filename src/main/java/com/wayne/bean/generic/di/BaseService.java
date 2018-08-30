package com.wayne.bean.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: wayne
 * @Date: 2018/8/30
 * @Description:
 */
public class BaseService<T> {
    @Autowired
    protected BaseRepository<T> repository;

    public void add() {
        System.out.println("add");
        System.out.println(repository);
    }
}
