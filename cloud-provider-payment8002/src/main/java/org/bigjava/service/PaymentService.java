package org.bigjava.service;

import org.apache.ibatis.annotations.Param;
import org.bigjava.entities.Payment;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 21:24
 * @Version v1.0
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
