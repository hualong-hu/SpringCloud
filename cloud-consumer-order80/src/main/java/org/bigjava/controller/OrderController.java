package org.bigjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-22 13:06
 * @Version v1.0
 */
@RestController
@Slf4j
public class OrderController {
    //单机版
//    public static final String PAYMENT_URL = "http://localhost:8001";

    //集群版 重点是这里，改成 提供者在Eureka 上的名称，而且无需写端口号
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        //getForObject()返回对象为响应体中数据转化成的对象，基本上可以理解为JSON
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    /**
     * 如果使用 ForObject 得到的就是提供者返回的对象，
     * 而如果要使用 ForEntity 得到的是 ResponseEntity对象，使用getBody()才能得到提供者返回的数据。
     * @data: 2020-11-24-23:12
     * @method: getPayment2
     * @params: [id]
     * @return: org.bigjava.entities.CommonResult<java.lang.Object>
     */
    @GetMapping(value = "/consumer/getForEntity/get/{id}")
    public CommonResult<Object> getPayment2(@PathVariable("id")Long id){
        //getForEntity()返回对象为ResponseEntity对象，包含了响应中的一些重要信息，如响应头，响应状态码，响应体等
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            //获取响应状态码和请求头信息
            System.out.println(entity.getStatusCodeValue()+"\t"+entity.getHeaders());
            return entity.getBody();
        }else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }
}
