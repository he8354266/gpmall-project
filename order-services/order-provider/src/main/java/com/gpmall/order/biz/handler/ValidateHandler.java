package com.gpmall.order.biz.handler;

import com.gpmall.commons.tool.exception.BizException;
import com.gpmall.order.biz.context.CreateOrderContext;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.constant.OrderRetCode;
import com.gpmall.order.dal.persistence.OrderMapper;
import com.gpmall.user.IMemberService;
import com.gpmall.user.dto.QueryMemberRequest;
import com.gpmall.user.dto.QueryMemberResponse;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Date 2023/4/11 13:47
 * @Author hy
 **/
@Slf4j
@Component
public class ValidateHandler extends AbstractTransHandler {
    @Resource
    private OrderMapper orderMapper;
    @Reference
    private IMemberService memberService;


    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handler(TransHandlerContext context) {
        log.info("begin ValidateHandler :context:" + context);
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        QueryMemberRequest queryMemberRequest = new QueryMemberRequest();
        queryMemberRequest.setUserId(createOrderContext.getUserId());
        QueryMemberResponse response = memberService.queryMemberById(queryMemberRequest);
        if (OrderRetCode.SUCCESS.getCode().equals(response.getCode())) {
            createOrderContext.setBuyerNickName(response.getUsername());
        } else {
            throw new BizException(response.getCode(), response.getMsg());
        }
        return true;
    }
}
