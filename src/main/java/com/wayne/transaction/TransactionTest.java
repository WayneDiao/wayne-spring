package com.wayne.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Author: wayne
 * @Date: 2018/9/8
 * @Description:
 */
public class TransactionTest {
    private ApplicationContext context = null;
    private BookShopDao dao = null;
    private BookShopService service = null;
    private Cashier cashier = null;
    {
        context = new ClassPathXmlApplicationContext("classpath:jdbc/application-jdbc.xml");
        dao = context.getBean(BookShopDao.class);
        service = context.getBean(BookShopService.class);
        cashier = context.getBean(Cashier.class);
    }

    /*测试事务传播行为*/
    @Test
    public void test5() {
        cashier.checkOut("wayne",Arrays.asList(1002,1001));
    }

    @Test
    public void test4() {
        service.purchase("wayne",1001);
    }

    @Test
    public void test3() {
        dao.updateUserAccount("wayne",123.2);
    }

    @Test
    public void test2() {
        dao.updateBookStock(1001);
    }

    @Test
    public void test1() {
        System.out.println(dao.findBookPriceByIsbn(1001));
    }
}
