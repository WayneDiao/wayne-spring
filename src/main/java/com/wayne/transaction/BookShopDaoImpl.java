package com.wayne.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author: wayne
 * @Date: 2018/9/8
 * @Description:
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Double findBookPriceByIsbn(int isbn) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, isbn);
    }

    public void updateBookStock(int isbn) {

        /*检查书的库存是够足够,若不够,则抛出异常*/
        String sql2 = "select stock from book_stock where isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2,Integer.class,isbn);
        if (stock == 0) {
            throw new BookStockException("库存不足");
        }



        String sql = "update book_stock set stock = stock - 1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    public void updateUserAccount(String userName, Double price) {
        /*检查余额是否足够，若不足，则抛出异常*/
        String sql2 = "select balance from account where user_name = ?";
        Double balance = jdbcTemplate.queryForObject(sql2,Double.class,userName);
        if (balance < price) {
            throw new AccountException("余额不足");
        }
        String sql = "update account set balance = balance - ? where user_name = ?";
        jdbcTemplate.update(sql, price, userName);
    }
}
