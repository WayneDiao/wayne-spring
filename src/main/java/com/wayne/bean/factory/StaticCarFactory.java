package com.wayne.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description: 静态工厂方法：直接调用某个类的静态方法就可以返回bean的实例
 */
public class StaticCarFactory {

    private static Map<String,Car> map = new HashMap<String, Car>();

    static {
        map.put("audi",new Car("audi",300000d));
        map.put("ford",new Car("ford",50000d));
    }

    /*静态工厂方法*/
    public static Car getCar(String name) {

        return map.get(name);
    }
}
