package com.wayne.bean.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization...." + bean + "," + beanName);
        Car car = new Car();
        car.setBrand("ford");
        return car;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization...." + bean + "," + beanName);
        if ("car".equals(beanName)) {
            //......
            System.out.println();
        }
        return bean;
    }
}
