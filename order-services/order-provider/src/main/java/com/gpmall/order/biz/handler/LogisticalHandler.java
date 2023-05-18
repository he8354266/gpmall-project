package com.gpmall.order.biz.handler;

import com.gpmall.commons.tool.exception.BaseBusinessException;
import com.gpmall.order.biz.context.CreateOrderContext;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.constant.OrderRetCode;
import com.gpmall.order.dal.entitys.OrderShipping;
import com.gpmall.order.dal.persistence.OrderShippingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/4/13 10:49
 * @Author hy
 **/
@Slf4j
@Component
public class LogisticalHandler extends AbstractTransHandler {
    @Resource
    private OrderShippingMapper orderShippingMapper;

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handler(TransHandlerContext context) {
        log.info("begin LogisticalHandler :context:" + context);
        try {
            CreateOrderContext createOrderContext = (CreateOrderContext) context;
            OrderShipping orderShipping = new OrderShipping();
            orderShipping.setOrderId(createOrderContext.getOrderId());
            orderShipping.setReceiverName(createOrderContext.getUserName());
            orderShipping.setReceiverAddress(createOrderContext.getStreetName());
            orderShipping.setReceiverPhone(createOrderContext.getTel());
            orderShipping.setCreated(new Date());
            orderShipping.setUpdated(new Date());
            orderShippingMapper.insertSelective(orderShipping);
        } catch (Exception e) {
            throw new BaseBusinessException(OrderRetCode.SHIPPING_DB_SAVED_FAILED.getCode(), OrderRetCode.SHIPPING_DB_SAVED_FAILED.getMessage());
        }
        return true;
    }
}
