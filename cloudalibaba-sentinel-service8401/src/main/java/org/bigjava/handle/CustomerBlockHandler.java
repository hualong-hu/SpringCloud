package org.bigjava.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.bigjava.entities.CommonResult;
import org.bigjava.entities.Payment;

/**
 * @ProjectName: SpringCloud
 * @ClassName: CustomerBlockHandler
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-01 21:25
 * @Version v1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444, "按客户自定义,global handlerException ------>1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444, "按客户自定义,global handlerException ------>2");
    }
}
