package com.wayne.bean.spel;

import lombok.Data;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
@Data
public class Person {
    private String name;
    private Car car;

    /*引用Address bean的city属性*/
    private String city;

    /*根据car的price确定info，if >= 300000 金领 else 白领*/
    private String info;
}
