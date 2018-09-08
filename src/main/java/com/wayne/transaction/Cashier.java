package com.wayne.transaction;

import java.util.List;

/**
 * @Author: wayne
 * @Date: 2018/9/8
 * @Description:
 */
public interface Cashier {
    public void checkOut(String userName, List<Integer> isbns);
}
