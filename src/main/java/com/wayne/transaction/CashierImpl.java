package com.wayne.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: wayne
 * @Date: 2018/9/8
 * @Description:
 */
@Service
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService service;



    @Transactional
    @Override
    public void checkOut(String userName, List<Integer> isbns) {
        for (Integer isbn : isbns) {
            service.purchase(userName,isbn);
        }
    }
}
