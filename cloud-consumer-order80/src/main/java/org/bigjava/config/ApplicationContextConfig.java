package org.bigjava.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: SpringCloud
 * @ClassName: ApplicationContextConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-22 13:08
 * @Version v1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //这个注解，就赋予了RestTemplate 负载均衡的能力
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
