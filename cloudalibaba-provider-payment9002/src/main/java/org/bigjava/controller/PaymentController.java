package org.bigjava.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-30 15:41
 * @Version v1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id")Integer id){
        return "nacos registry,serverPort： "+serverPort+"\t id="+id;
    }
}
