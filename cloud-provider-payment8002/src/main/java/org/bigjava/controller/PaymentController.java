package org.bigjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.bigjava.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 21:28
 * @Version v1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("********插入的结果是 ----->"+i);
        if (i > 0 ){
            return new CommonResult<>(200, "插入数据库成功!服务端口号是："+port,i);
        }else {
            return new CommonResult<>(404, "插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询的结果是 ----->" + payment);

        if (payment != null){
            return new CommonResult<>(200, "查询成功！服务端口号是："+port,payment);
        }else {
            return new CommonResult<>(404, "查询失败，数据库没有对应记录"+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }

}
