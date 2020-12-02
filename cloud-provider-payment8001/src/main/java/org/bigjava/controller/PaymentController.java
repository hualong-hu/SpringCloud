package org.bigjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.bigjava.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 21:28
 * @Version v1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("********插入的结果是 ----->"+i);
        if (i > 0 ){
            return new CommonResult<>(200, "插入数据库成功!服务端口号是："+port,i);
        }else {
            return new CommonResult<>(404, "插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询的结果是 ----->" + payment);

        if (payment != null){
            return new CommonResult<>(200, "查询成功！服务端口号是："+port,payment);
        }else {
            return new CommonResult<>(404, "查询失败，数据库没有对应记录"+id,null);
        }
    }

    /**
     * 对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
     * @data: 2020-11-23-22:42
     * @method: getDiscovery
     * @params: []
     * @return: org.springframework.cloud.client.discovery.DiscoveryClient
     */
    @GetMapping(value = "/payment/discovery")
    public DiscoveryClient getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service = " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println("instance = " + instance.getServiceId()+"\t"+instance.getHost()+
                    "\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getInstanceId());
        }
        return this.discoveryClient;
    }

    /**
     * 测试openfeign超时控制
     * @data: 2020-11-25-22:33
     * @method: paymentFeignTimeout
     * @params: []
     * @return: java.lang.String
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin(){
        return "hi,i am paymentZipkin server fall back , welcome ! O(∩_∩)O哈哈~";
    }
}
