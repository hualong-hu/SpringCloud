package org.bigjava.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.bigjava.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ProjectName: SpringCloud
 * @ClassName: CircleBreakerController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-01 22:25
 * @Version v1.0
 */
@RestController
public class CircleBreakerController {

    private static final String PAYMENT_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")     //没有配置
//    @SentinelResource(value = "fallback",fallback = "handleFallback")   //fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")   //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handleFallback",blockHandler = "blockHandler")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        CommonResult<Payment> result = restTemplate.getForObject(PAYMENT_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    //本例是fallback
    public CommonResult<Payment> handleFallback(@PathVariable Long id,Throwable throwable){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底异常handleFallback,exception内容："+throwable.getMessage(),payment);
    }
    //====blockHandler   BlockException e必须有这个参数
    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "---无此流水--BlockException:  "+e, payment);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}