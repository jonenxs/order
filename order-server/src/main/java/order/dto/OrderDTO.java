package order.dto;

import lombok.Data;
import order.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家微信Openid
     */
    private String buyerOpenid;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态 默认为0 新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
