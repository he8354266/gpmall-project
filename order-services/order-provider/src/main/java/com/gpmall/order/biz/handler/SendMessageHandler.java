package com.gpmall.order.biz.handler;

import com.gpmall.order.biz.context.TransHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO
 * @Date 2023/4/13 10:44
 * @Author hy
 **/
@Component
@Slf4j
public class SendMessageHandler extends AbstractTransHandler {
    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handler(TransHandlerContext context) {
        return false;
    }
}
