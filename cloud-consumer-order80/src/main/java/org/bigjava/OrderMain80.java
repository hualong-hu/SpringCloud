package org.bigjava;

import org.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderMain80
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 22:39
 * @Version v1.0
 */
@SpringBootApplication
@EnableEurekaClient
//指定该负载均衡规则对哪个提供者服务使用(name值一直要全大写)           加载自定义规则的配置类
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
