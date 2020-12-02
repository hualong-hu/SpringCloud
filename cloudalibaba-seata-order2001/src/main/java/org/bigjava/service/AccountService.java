package org.bigjava.service;

import org.bigjava.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @ProjectName: SpringCloud
 * @ClassName: AccountService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-02 16:59
 * @Version v1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId,
                          @RequestParam("money") BigDecimal money);
}
