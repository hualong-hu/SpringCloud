package org.bigjava.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-26 9:45
 * @Version v1.0
 */
@Service
//全局配置降级方法的注解
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentService {

    /**
     * 正常访问，肯定ok
     * @data: 2020-11-26-10:19
     * @method: paymentInfo_OK
     * @params: [id]
     * @return: java.lang.String
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id： "+id+"\t"+"O(∩_∩)O哈哈~";

    }

    /**
     *
     * @data: 2020-11-26-15:15
     * @method: paymentInfo_Timeout
     * @params: [id]
     * @return: java.lang.String
     */
    //一旦调用服务方法失败并抛出异常信息后，会自动调用@HystrixCommand标注好的fallbackMethod属性中指定的方法
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            //设置自身调用超时时间的峰值，峰值内可以正常运行
//            //设置峰值，超过 3 秒，就会调用兜底方法，这个时间也可以由feign控制
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
    //开启hystrix服务降级功能
    @HystrixCommand(commandProperties = {
//            //设置自身调用超时时间的峰值，峰值内可以正常运行
//            //设置峰值，超过 3 秒，就会调用兜底方法，这个时间也可以由feign控制
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),

            // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.enabled", value="true"),
            //请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
            // 时间窗口期
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60"),
            //整体意思：10秒内 10次请求，有6次失败，就跳闸
    })
    public String paymentInfo_Timeout(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_Timeout,id： "+id+"\t"+"O(∩_∩)O哈哈~  耗时"+time+"  秒";

    }

    /**
     * 兜底方法，根据上述配置，程序内发生异常、或者运行超时，都会执行该兜底方法
     * @data: 2020-11-26-15:27
     * @method: paymentInfo_TimeOutHandler
     * @params: [id]
     * @return: java.lang.String
     */
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" 服务繁忙或运行报错，请稍后再试,id： "+id+"  \t"+"o(╥﹏╥)o";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }

    /**
     * 测试服务熔断
     * @data: 2020-11-27-10:51
     * @method: paymentCircuitBreaker
     * @params: [id]
     * @return: java.lang.String
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {

            // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.enabled", value="true"),
            //请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
            // 时间窗口期
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60"),
            //整体意思：10秒内 10次请求，有6次失败，就跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        //模拟发生异常
        if(id < 0){
            throw new RuntimeException("*****id，不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后再试....";
    }
}
