package org.bigjava.controller;

import org.bigjava.bean.CommonResult;
import org.bigjava.bean.Order;
import org.bigjava.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-02 17:15
 * @Version v1.0
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
