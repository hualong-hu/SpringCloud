package org.bigjava.service;

import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-01 23:33
 * @Version v1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
