package org.bigjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderFeignMain80
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-25 10:36
 * @Version v1.0
 */
@SpringBootApplication
@EnableFeignClients
//@RibbonClient
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
