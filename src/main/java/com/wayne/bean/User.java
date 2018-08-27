package com.wayne.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: wayne
 * @Date: 2018/8/27
 * @Description:
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private Car car;
}
