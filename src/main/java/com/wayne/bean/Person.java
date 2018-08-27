package com.wayne.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: wayne
 * @Date: 2018/8/27
 * @Description:
 */
@Data
public class Person {
    private List<Car> cars;
    private Map<String, String> map;
    private Properties properties;
}
