package com.nxs.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

//@EnableDiscoveryClient
//@SpringBootApplication
//@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients(basePackages = "com.nxs.product.client")
@SpringCloudApplication
@ComponentScan(basePackages = "com.nxs")
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}




