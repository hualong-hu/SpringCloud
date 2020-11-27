package org.bigjava.service.impl;

import org.apache.ibatis.annotations.Param;
import org.bigjava.dao.PaymentDao;
import org.bigjava.entities.Payment;
import org.bigjava.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 21:25
 * @Version v1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    public int create(Payment payment){
        return paymentDao.create(payment);
    };

    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    };
}
