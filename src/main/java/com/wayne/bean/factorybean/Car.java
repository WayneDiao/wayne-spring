package com.wayne.bean.factorybean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private Double price;
}
