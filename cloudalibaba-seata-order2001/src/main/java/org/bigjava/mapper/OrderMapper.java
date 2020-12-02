package org.bigjava.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bigjava.bean.Order;

/**
 * @ProjectName: SpringCloud
 * @ClassName: OrderMapper
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-02 16:50
 * @Version v1.0
 */
@Mapper
public interface OrderMapper {
    //1、新建订单
    void create(Order order);

    //2、修改订单状态，从2改为1
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
