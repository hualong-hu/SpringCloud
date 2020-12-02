package org.bigjava.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"org.bigjava.mapper"})
public class MyBatisConfig {

}
