package org.bigjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: SpringCloud
 * @ClassName: Payment
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-21 21:05
 * @Version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;
}
