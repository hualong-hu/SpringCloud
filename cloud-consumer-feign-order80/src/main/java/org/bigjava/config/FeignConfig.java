package org.bigjava.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: SpringCloud
 * @ClassName: FeignConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-25 22:47
 * @Version v1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


}
