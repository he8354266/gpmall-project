package com.gpmall.order.biz.convert;

import com.gpmall.commons.result.AbstractRequest;
import com.gpmall.commons.result.AbstractResponse;
import com.gpmall.order.constant.OrderRetCode;
import com.gpmall.order.biz.context.CreateOrderContext;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.dto.CreateOrderRequest;
import com.gpmall.order.dto.CreateOrderResponse;

/**
 * @Description //TODO
 * @Date 2023/4/6 10:25
 * @Author hy
 **/
public class CreateOrderConvert implements TransConvert {
    @Override
    public TransHandlerContext convertRequest2Ctx(AbstractRequest req, TransHandlerContext context) {
        CreateOrderRequest createOrderRequest = (CreateOrderRequest) req;
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        createOrderContext.setAddressId(createOrderRequest.getAddressId());
        createOrderContext.setCartProductDtoList(createOrderRequest.getCartProductDtoList());
        createOrderContext.setOrderTotal(createOrderRequest.getOrderTotal());
        createOrderContext.setStreetName(createOrderRequest.getStreetName());
        createOrderContext.setTel(createOrderRequest.getTel());
        createOrderContext.setUserId(createOrderRequest.getUserId());
        createOrderContext.setUserName(createOrderRequest.getUserName());
        createOrderContext.setUniqueKey(createOrderRequest.getUniqueKey());
        return createOrderContext;
    }

    @Override
    public AbstractResponse convertCtx2Respond(TransHandlerContext ctx) {
        CreateOrderContext createOrderContext = (CreateOrderContext) ctx;
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setOrderId(createOrderContext.getOrderId());
        createOrderResponse.setCode(OrderRetCode.SUCCESS.getCode());
        createOrderResponse.setMsg(OrderRetCode.SUCCESS.getMessage());
        return createOrderResponse;
    }
}
