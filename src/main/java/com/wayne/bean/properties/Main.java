package com.wayne.bean.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: wayne
 * @Date: 2018/8/28
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean/beans-properties.xml");

        DataSource dataSource = context.getBean("dataSource",DataSource.class);
        System.out.println(dataSource.getConnection());

    }
}
