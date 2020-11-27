package org.bigjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderConsulController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-24 14:55
 * @Version v1.0
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String payment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul", String.class);
    }




}
