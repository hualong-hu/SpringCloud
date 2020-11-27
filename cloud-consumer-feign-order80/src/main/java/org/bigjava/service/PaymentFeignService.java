package org.bigjava.service;

import org.bigjava.config.FeignConfig;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentFeignService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-25 15:29
 * @Version v1.0
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",configuration = FeignConfig.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
