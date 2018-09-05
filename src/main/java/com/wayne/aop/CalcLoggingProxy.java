package com.wayne.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: wayne
 * @Date: 2018/9/5
 * @Description:
 */
public class CalcLoggingProxy {
    //要代理的对象
    private CalcService service;

    public CalcLoggingProxy(CalcService service) {
        this.service = service;
    }

    public CalcService getService() {
        CalcService calcService = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = service.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] classes = new Class[]{CalcService.class};
        //当调用代理对象其中的方法时，该执行的代码
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的那个代理对象，一般情况下，在invoke中都不使用该对象,会造成死循环 内存溢出
             * @param method 正在被调用的方法
             * @param args 调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("Wayne --> The Method " + methodName + "begins with " + Arrays.asList(args));
                //执行方法
                Object o = method.invoke(service,args);
                //日志
                System.out.println("Wayne --> The Method " + methodName + " ends with " + o);
                return o;
            }
        };
        calcService = (CalcService) Proxy.newProxyInstance(loader,classes,handler);

        return calcService;
    }
}
