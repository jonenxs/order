package com.nxs.order.client;

import com.nxs.order.dataobject.ProductInfo;
import com.nxs.order.dto.CartDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsd();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody  List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
