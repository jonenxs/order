package com.nxs.order.repository;

import com.nxs.order.OrderApplicationTests;
import com.nxs.order.dataobject.OrderMaster;
import com.nxs.order.enums.OrderStatusEnum;
import com.nxs.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("13212345678");
        orderMaster.setBuyerOpenid("12345678");
        orderMaster.setBuyerAddress("北京市");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);

        Assert.assertTrue(result != null);
    }
}