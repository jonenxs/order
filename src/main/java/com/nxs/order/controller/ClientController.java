package com.nxs.order.controller;

import com.nxs.order.client.ProductClient;
import com.nxs.order.dataobject.ProductInfo;
import com.nxs.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1.第一种方式(直接使用restTemplate，url写死)
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
        //2.第二种方式（利用LoadBalancerClient通过应用名获取url,然后使用restTemplate）
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        serviceInstance.getHost();
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);

        //3.第三种方式（利用@LoadBalanced注解，可以在restTemplat里使用应用名字）
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        //4.使用fegin客户端
        String response = productClient.productMsd();
        log.info("response={}", response);
        return response;
    }


    @GetMapping("/productDecreaseStock")
    public String getProductList(){
        CartDTO cartDTO = new CartDTO("157875196366160022", 3);
        productClient.decreaseStock(Arrays.asList(cartDTO));
        return "ok";
    }
}
