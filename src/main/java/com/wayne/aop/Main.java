package com.wayne.aop;

/**
 * @Author: wayne
 * @Date: 2018/9/5
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        CalcService service = new CalcServiceImpl();

        System.out.println(service.add(1,2));
        System.out.println(service.sub(3,2));

        CalcService calcService = new CalcLoggingProxy(service).getService();

        System.out.println(calcService.add(1,2));
        System.out.println(calcService.sub(3,2));
    }
}
