package org.bigjava.service;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentFallbackService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-26 23:34
 * @Version v1.0
 */
@Component
//实现PaymentHystrixService接口
//在这种方式一般是在客户端，即消费者端，首先上面再controller中添加的
// @HystrixCommand 和 @DefaultProperties两个注解去掉。就是保持原来的controller
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK ----> 发生异常";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "paymentTimeout ----> 发生异常";
    }
}
