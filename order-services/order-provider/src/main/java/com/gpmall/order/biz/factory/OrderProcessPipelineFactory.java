package com.gpmall.order.biz.factory;

import com.gpmall.order.biz.context.CreateOrderContext;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.biz.convert.CreateOrderConvert;
import com.gpmall.order.biz.convert.TransConvert;
import com.gpmall.order.biz.handler.*;
import com.gpmall.order.dto.CreateOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description //TODO
 * @Date 2023/6/14 15:03
 * @Author hy
 **/
@Slf4j
@Service
public class OrderProcessPipelineFactory extends AbstranctTransPipelineFactory<CreateOrderRequest> {
    @Autowired
    private InitOrderHandler initOrderHandler;
    @Autowired
    private ValidateHandler validateHandler;
    @Autowired
    private LogisticalHandler logisticalHandler;
    @Autowired
    private ClearCartItemHandler clearCartItemHandler;
    @Autowired
    private SubStockHandler subStockHandler;
    @Autowired
    private SendMessageHandler sendMessageHandler;

    @Override
    protected void doBuild(TransPipeline pipeline) {
        pipeline.addLast(validateHandler);
        pipeline.addLast(subStockHandler);
        pipeline.addLast(initOrderHandler);
        pipeline.addLast(logisticalHandler);
        pipeline.addLast(clearCartItemHandler);
        pipeline.addLast(sendMessageHandler);
    }

    @Override
    protected TransHandlerContext createContext() {
        CreateOrderContext orderContext = new CreateOrderContext();
        return orderContext;
    }

    @Override
    protected TransConvert createConvert() {
        return new CreateOrderConvert();
    }
}
