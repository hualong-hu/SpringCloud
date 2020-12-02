package org.bigjava.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.bigjava.handle.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringCloud
 * @ClassName: RateLimitController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-01 21:09
 * @Version v1.0
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    // blockHandler = "handleException" 处理降级的方法名
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按照资源名限流测试0K", new Payment(2020L,"serial001"));
    }

    //降级方法
    public CommonResult handleException(BlockException e){
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200, "按客户自定义",new Payment(2020L, "serial003"));
    }
}
