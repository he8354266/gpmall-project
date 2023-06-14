package com.gpmall.order.consumer;

import com.gpmall.commons.mq.config.RabbitMqConfig;
import com.gpmall.order.dal.entitys.Order;
import com.gpmall.order.dal.persistence.OrderItemMapper;
import com.gpmall.order.dal.persistence.OrderMapper;
import com.gpmall.order.dal.persistence.StockMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description //TODO
 * @Date 2023/5/18 11:23
 * @Author hy
 **/
@Slf4j
@Component
@Transactional
public class OrderCancelConsumer {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private StockMapper stockMapper;

    @RabbitListener(queues = RabbitMqConfig.DELAY_QUEUE)
    public void process(String context, Message message, Channel channel) throws IOException {
        try {
            log.info("开始执行订单[{}]的支付超时订单关闭......", context);
            Order order = new Order();
            order.setOrderId(context);
            //先查询订单是否是待支付状态
            Order order1 = orderMapper.selectByPrimaryKey(order);
            //no pay
            if(order1.getStatus()==0){

            }
        } catch (Exception e) {

        }

    }
}
