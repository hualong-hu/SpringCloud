package org.bigjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: SpringCloud
 * @ClassName: CommonResult
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 21:07
 * @Version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
