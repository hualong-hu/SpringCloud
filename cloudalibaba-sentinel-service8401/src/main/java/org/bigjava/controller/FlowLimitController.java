package org.bigjava.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: SpringCloud
 * @ClassName: FlowLimitController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-01 10:58
 * @Version v1.0
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value="/testA")
    public String  TestA(){
        return "--------testA";
    }

    @GetMapping(value="/testB")
    public String  TestB(){
        log.info(Thread.currentThread().getName()+"\t"+"......testB");
//        System.out.println(Thread.currentThread().getName()+"\t"+"......testB");
        return "--------testB";
    }

    @GetMapping(value="/testD")
    public String  TestD(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD  测试RT");
//        log.info("testD 异常比例");
//        int age = 10/0;
//        return "--------testD";
        log.info("testD 测试异常数");
        int age = 10/0;
        return "--------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    //这个value是随意的值，并不和请求路径必须一致
    //在填写热点限流的 资源名 这一项时，可以填 /testHotKey 或者是 @SentinelResource的value的值
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "----------testHotKey";
    }

    //类似Hystrix 的兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "testHotKey__fail o(╥﹏╥)o";
    }
}
