package org.bigjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.bigjava.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderFeignController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-25 10:58
 * @Version v1.0
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * 测试openfeign超时控制
     * @data: 2020-11-25-22:33
     * @method: paymentFeignTimeout
     * @params: []
     * @return: java.lang.String
     */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign的底层是ribbon,客户端一般默认等待一秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
