package com.wayne.bean.cycle;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
public class Car {
    public Car() {
        System.out.println("car Constructor");
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("set brand.....");
        this.brand = brand;
    }

    public void init() {
        System.out.println("init.....");
    }

    public void destroy() {
        System.out.println("destroy.....");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
