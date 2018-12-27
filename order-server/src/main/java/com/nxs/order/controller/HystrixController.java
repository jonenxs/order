package com.nxs.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //超时设置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })//(fallbackMethod = "fallback")
    //熔断器设置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//滚动时间窗口内，断路器最少请求数
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//休眠时间窗
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//短路器再次打开的百分比条件
//    })
    @HystrixCommand
    @GetMapping("getProductInfoList")
    public String getProductInfoList(Integer number) {
        if(number % 2 == 0){
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8005/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);
//        throw new RuntimeException("发生异常了");
    }

    private String fallback() {
        return "太拥挤了，请稍后再试~~";
    }

    private String defaultFallback() {
        return "[default]太拥挤了，请稍后再试~~";
    }
}
