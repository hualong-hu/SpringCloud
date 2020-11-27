package org.bigjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: SpringCloud
 * @ClassName: EurekaMain7001
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-23 14:18
 * @Version v1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }
}
