package org.bigjava.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.bigjava.bean.Order;
import org.bigjava.mapper.OrderMapper;
import org.bigjava.service.AccountService;
import org.bigjava.service.OrderService;
import org.bigjava.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-02 17:00
 * @Version v1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     * @data: 2020-12-02-17:14
     * @method: create
     * @params: [order]
     * @return: void
     */
    @Override
    //只需要在业务类的方法上加上该注解，name值自定义唯一即可。
    @GlobalTransactional(name = "luosheng",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-------->开始新建订单");
        orderMapper.create(order);

        log.info("-------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------->订单微服务开始调用库存，做扣减end");

        log.info("-------->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------->订单微服务开始调用账户，做扣减end");

        log.info("-------->开始修改订单状态");
        orderMapper.update(order.getUserId(), 0);
        log.info("-------->修改订单状态结束");

        log.info("-------->下订单结束了，(*^▽^*)");
    }
}
