package com.gpmall.order.biz.handler;

import com.gpmall.order.biz.context.TransHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description //TODO
 * @Date 2023/4/11 9:26
 * @Author hy
 **/
@Slf4j
public class DefaultTransPipeline implements TransPipeline {
    public DefaultTransPipeline(TransHandlerContext context) {
    }

    @Override
    public void start() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public <T extends TransHandlerContext> T getContext() {
        return null;
    }

    @Override
    public void addFirst(TransHandler... handler) {

    }

    @Override
    public void addLast(TransHandler... handler) {

    }
}
