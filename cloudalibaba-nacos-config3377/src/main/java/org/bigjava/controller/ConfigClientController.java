package org.bigjava.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringCloud
 * @ClassName: ConfigClientController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-30 21:51
 * @Version v1.0
 */
@RestController
@RefreshScope       //支持Nacos的动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
