package com.wayne.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description: 自定义的FactoryBean 需要实现接口FactoryBean
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /*返回bean对象*/
    public Car getObject() throws Exception {

        return new Car(brand,500000d);
    }

    /*返回bean的类型*/
    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return true;
    }
}
