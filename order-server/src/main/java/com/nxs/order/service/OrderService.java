package com.nxs.order.service;

import com.nxs.order.dto.OrderDTO;

public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);


    /**
     * 完结订单(只能卖家来操作)
     * @param orderId 订单id
     * @return
     */
    OrderDTO finish(String orderId);
}
