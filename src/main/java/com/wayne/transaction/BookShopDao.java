package com.wayne.transaction;

/**
 * @Author: wayne
 * @Date: 2018/9/8
 * @Description:
 */
public interface BookShopDao {
    /*根据书号获取书的单价*/
    public Double findBookPriceByIsbn(int isbn);

    /*更新书的库存*/
    public void updateBookStock(int isbn);

    /*更新账户余额*/
    public void updateUserAccount(String userName,Double price);


}
