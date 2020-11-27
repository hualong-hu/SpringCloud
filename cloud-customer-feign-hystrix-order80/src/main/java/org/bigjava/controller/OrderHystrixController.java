package org.bigjava.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.bigjava.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderHystrixController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-26 11:11
 * @Version v1.0
 */
@RestController
@Slf4j
//全局降级服务配置
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){

        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //一旦调用服务方法失败并抛出异常信息后，会自动调用@HystrixCommand标注好的fallbackMethod属性中指定的方法
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            //设置自身调用超时时间的峰值，峰值内可以正常运行
//            //设置峰值，超过 1.5 秒，就会调用兜底方法，这个时间也可以由feign控制
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand(commandProperties = {
//            //设置自身调用超时时间的峰值，峰值内可以正常运行
//            //设置峰值，超过 1.5 秒，就会调用兜底方法，这个时间也可以由feign控制
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    public String paymentTimeout(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentTimeout(id);
    }
    /**
     * 定义的兜底方法不能带参数
     * 兜底方法，根据上述配置，程序内发生异常、或者运行超时，都会执行该兜底方法
     * @data: 2020-11-26-22:44
     * @method: paymentTimeOutFallbackMethod
     * @params: [id]
     * @return: java.lang.String
     */
    public String paymentTimeOutFallbackMethod(){
        return "我是消费者80，对方支付系统繁忙请10秒后再试或者自己运行出错请检查自己o(╥﹏╥)o";
    }

    /**
     * 全局配置降级的兜底方法
     * @data: 2020-11-26-23:22
     * @method: payment_Global_FallbackMethod
     * @params: []
     * @return: java.lang.String
     */
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }
}
