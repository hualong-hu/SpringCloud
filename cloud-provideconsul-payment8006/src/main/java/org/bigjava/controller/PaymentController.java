package org.bigjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-24 14:15
 * @Version v1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul"+port+"\t  "+ UUID.randomUUID().toString();
    }
}
