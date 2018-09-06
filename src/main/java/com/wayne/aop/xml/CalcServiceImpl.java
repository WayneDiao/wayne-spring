package com.wayne.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @Author: wayne
 * @Date: 2018/9/5
 * @Description:
 */
public class CalcServiceImpl implements CalcService {
    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    public Integer sub(Integer x, Integer y) {
        return x - y;
    }

    public Integer mul(Integer x, Integer y) {
        return x * y;
    }

    public Integer div(Integer x, Integer y) {
        return x / y;
    }
}
