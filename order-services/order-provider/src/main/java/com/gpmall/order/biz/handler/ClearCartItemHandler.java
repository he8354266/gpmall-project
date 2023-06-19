package com.gpmall.order.biz.handler;

import com.gpmall.commons.tool.exception.BizException;
import com.gpmall.order.biz.context.CreateOrderContext;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.constant.OrderRetCode;
import com.gpmall.shopping.ICartService;
import com.gpmall.shopping.dto.ClearCartItemRequest;
import com.gpmall.shopping.dto.ClearCartItemResponse;
import org.apache.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO
 * @Date 2023/6/15 9:41
 * @Author hy
 **/
@Slf4j
@Component
public class ClearCartItemHandler extends AbstractTransHandler {
    @Reference(check = false, mock = "com.gpmall.order.biz.mock.MockCartService")
    private ICartService cartService;

    //是否采用异步方式执行
    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handler(TransHandlerContext context) {
        log.info("begin - ClearCartItemHandler-context:" + context);
        //TODO 缓存失效和下单是属于两个事物操作，需要保证成功，后续可以改造成消息队列的形式来实现
        ClearCartItemRequest request = new ClearCartItemRequest();
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        request.setProductIds(createOrderContext.getBuyProductIds());
        request.setUserId(createOrderContext.getUserId());
        ClearCartItemResponse response = cartService.clearCartItemByUserID(request);
        if (response.getCode().equals(OrderRetCode.SUCCESS.getCode())) {
            return true;
        } else {
            throw new BizException(response.getCode(), response.getMsg());
        }
    }
}
