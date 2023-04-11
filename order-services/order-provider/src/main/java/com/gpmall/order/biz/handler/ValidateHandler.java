package com.gpmall.order.biz.handler;

import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.dal.persistence.OrderMapper;
import com.gpmall.user.IMemberService;
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
public class ValidateHandler extends AbstractTransHandler  {
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
        return false;
    }
}
