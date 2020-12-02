package org.bigjava;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: SpringCloud
 * @ClassName: ConfigClientMain3355
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-29 13:20
 * @Version v1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class,args);
    }

}
