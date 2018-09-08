package com.wayne.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: wayne
 * @Date: 2018/9/8
 * @Description:
 */
@Service
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao dao;

    /*
    * 添加事务注解
    * 使用 propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
    * 如何使用事务，默认取值为 REQUIRED ，即使用调用方法的事务
    * REQUIRES_NEW : 使用自己的事务，调用的方法的事务被挂起
    * 使用 isolation 指定事务的隔离级别,最常用为 READ_COMMITTED：读已提交
    * 默认情况下，spring的声明式对所有的运行时异常回滚，也可以通过对应属性进行设置
    * 使用timeout指定强制回滚之前，事务可以占用的时间，若超过时间，直接强制回滚
    */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 3)
    @Override
    public void purchase(String userName, Integer isbn) {

        /*获取书的单价*/
        Double price = dao.findBookPriceByIsbn(isbn);

        /*更新库存*/
        dao.updateBookStock(isbn);

        /*更新余额*/
        dao.updateUserAccount(userName,price);

    }
}
