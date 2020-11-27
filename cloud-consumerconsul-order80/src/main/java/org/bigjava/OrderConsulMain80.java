package org.bigjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderConsulMain80
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-24 14:52
 * @Version v1.0
 */
@SpringBootApplication
//该注解用于向使用consul作为注册中心时注册服务
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
