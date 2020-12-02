package org.bigjava.service;

import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentFallbackService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-01 23:36
 * @Version v1.0
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444, "服务降级返回，---PaymentFallbackService",new Payment(id, "errorSerial"));
    }
}
