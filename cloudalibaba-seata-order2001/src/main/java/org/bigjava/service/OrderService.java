package org.bigjava.service;

import org.bigjava.bean.Order;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-02 16:58
 * @Version v1.0
 */
public interface OrderService {
    void create(Order order);
}
