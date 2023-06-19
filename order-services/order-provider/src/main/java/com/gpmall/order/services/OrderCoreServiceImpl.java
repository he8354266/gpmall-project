package com.gpmall.order.services;

import com.gpmall.order.OrderCoreService;
import com.gpmall.order.biz.factory.OrderProcessPipelineFactory;
import com.gpmall.order.dal.persistence.OrderItemMapper;
import com.gpmall.order.dal.persistence.OrderMapper;
import com.gpmall.order.dal.persistence.OrderShippingMapper;
import com.gpmall.order.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Date 2023/6/14 15:00
 * @Author hy
 **/
@Slf4j
@Service(cluster = "failfast")
public class OrderCoreServiceImpl implements OrderCoreService {
    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Resource
    OrderShippingMapper orderShippingMapper;

    @Resource
    OrderProcessPipelineFactory orderProcessPipelineFactory;

    @Resource
    OrderCoreService orderCoreService;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        return null;
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest request) {
        return null;
    }

    @Override
    public DeleteOrderResponse deleteOrder(DeleteOrderRequest request) {
        return null;
    }

    @Override
    public void updateOrder(Integer status, String orderId) {

    }

    @Override
    public void deleteOrderWithTransaction(DeleteOrderRequest request) {

    }
}
