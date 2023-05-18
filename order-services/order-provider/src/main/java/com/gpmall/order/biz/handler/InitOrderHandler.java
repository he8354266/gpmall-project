package com.gpmall.order.biz.handler;

import com.gpmall.order.biz.callback.SendEmailCallback;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.dal.entitys.Order;
import com.gpmall.order.dal.persistence.OrderItemMapper;
import com.gpmall.order.dal.persistence.OrderMapper;
import com.gpmall.order.utils.GlobalIdGeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Date 2023/4/13 11:10
 * @Author hy
 **/
@Component
@Slf4j
public class InitOrderHandler extends AbstractTransHandler {
    @Resource
    private SendEmailCallback sendEmailCallback;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private GlobalIdGeneratorUtil globalIdGeneratorUtil;
    private final String ORDER_GLOBAL_ID_CACHE_KEY = "ORDER_ID";
    private final String ORDER_ITEM_GLOBAL_ID_CACHE_KEY = "ORDER_ITEM_ID";

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handler(TransHandlerContext context) {
        log.info("begin InitOrderHandler :context:" + context);
        Order order = new Order();
        String orderId = globalIdGeneratorUtil.getNextSeq(ORDER_GLOBAL_ID_CACHE_KEY, 1);
        return false;
    }
}
