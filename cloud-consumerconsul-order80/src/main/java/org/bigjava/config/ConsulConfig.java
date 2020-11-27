package org.bigjava.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: SpringCloud
 * @ClassName: ConsulConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-24 14:54
 * @Version v1.0
 */
@Configuration
public class ConsulConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
