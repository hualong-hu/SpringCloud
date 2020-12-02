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
 * @Date: 2020-12-01 22:24
 * @Version v1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
