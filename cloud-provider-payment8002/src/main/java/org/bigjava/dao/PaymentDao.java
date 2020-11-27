package org.bigjava.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bigjava.entities.Payment;

/**
 * @ProjectName: SpringCloud
 * @ClassName: PaymentDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 21:09
 * @Version v1.0
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
