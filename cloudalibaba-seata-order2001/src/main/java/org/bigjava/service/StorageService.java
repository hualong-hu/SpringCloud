package org.bigjava.service;

import org.bigjava.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: SpringCloud
 * @ClassName: StorageService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-02 16:59
 * @Version v1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId,
                          @RequestParam("count")Integer count);
}
