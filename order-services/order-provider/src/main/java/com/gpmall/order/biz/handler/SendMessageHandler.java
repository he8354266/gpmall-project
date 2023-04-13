package com.gpmall.order.biz.handler;

import com.gpmall.commons.mq.producer.RabbitMessageProducer;
import com.gpmall.order.biz.context.CreateOrderContext;
import com.gpmall.order.biz.context.TransHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO
 * @Date 2023/4/13 10:44
 * @Author hy
 **/
@Component
@Slf4j
public class SendMessageHandler extends AbstractTransHandler {
    @Autowired
    private RabbitMessageProducer rabbitMessageProducer;

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handler(TransHandlerContext context) {
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        //订单发送到rabbitmq
        try {
            rabbitMessageProducer.send(createOrderContext.getOrderId());
        } catch (Exception e) {
            log.error("发送订单id:{}到延迟队列失败" + createOrderContext.getOrderId());
            return false;
        }
        return true;
    }
}
