package org.bigjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: SpringCloud
 * @ClassName: GateWayMain9527
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-27 14:09
 * @Version v1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class GateWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
    }

}
