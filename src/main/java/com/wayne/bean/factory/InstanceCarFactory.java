package com.wayne.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description: 实例工厂的方法，即先需要创建工厂本身，再调用工厂的实例方法来返回bean的实例
 */
public class InstanceCarFactory {
    private Map<String,Car> map = null;

    public InstanceCarFactory() {
        map = new HashMap<String, Car>();
        map.put("audi",new Car("audi",300000d));
        map.put("ford",new Car("ford",50000d));
    }

    public Car getCar(String brand) {
        return map.get(brand);
    }
}
