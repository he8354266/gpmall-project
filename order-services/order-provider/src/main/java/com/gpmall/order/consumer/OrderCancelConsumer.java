package com.gpmall.order.consumer;

import com.gpmall.commons.mq.config.RabbitMqConfig;
import com.gpmall.order.constants.OrderConstants;
import com.gpmall.order.dal.entitys.Order;
import com.gpmall.order.dal.entitys.OrderItem;
import com.gpmall.order.dal.entitys.Stock;
import com.gpmall.order.dal.persistence.OrderItemMapper;
import com.gpmall.order.dal.persistence.OrderMapper;
import com.gpmall.order.dal.persistence.StockMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description //延迟队列订单取消监听
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
            if (order1.getStatus() == 0) {
                order.setStatus(OrderConstants.ORDER_STATUS_TRANSACTION_CANCEL);
                //状态设置为取消
                orderMapper.updateByPrimaryKey(order);
                //库存释放
                orderItemMapper.updateStockStatus(2, context);
                //库存还回去
                List<OrderItem> list = orderItemMapper.queryByOrderId(context);
                if (CollectionUtils.isNotEmpty(list)) {
                    List<Long> itemIds = list.stream().map(OrderItem::getItemId).collect(Collectors.toList());
                    //锁itemIds
                    List<Stock> stocks = stockMapper.findStocksForUpdate(itemIds);
                    stocks.stream().forEach(stock -> {
                        list.stream().forEach(one -> {
                            if (Objects.equals(one.getItemId(), stock.getItemId())) {
                                stock.setLockCount(-one.getNum());
                                stock.setStockCount(one.getNum().longValue());
                                //释放库存
                                stockMapper.updateStock(stock);
                                return;
                            }
                        });
                    });
                }
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("超时订单{}处理完毕", context);
        } catch (Exception e) {
            log.error("超时订单处理失败:{}", context);
            e.printStackTrace();
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }

    }
}
