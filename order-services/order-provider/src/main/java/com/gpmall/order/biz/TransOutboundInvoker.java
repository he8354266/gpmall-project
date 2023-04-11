package com.gpmall.order.biz;

import com.gpmall.order.biz.context.TransHandlerContext;

/**
 * @Description //TODO
 * @Date 2023/4/7 9:18
 * @Author hy
 **/
public interface TransOutboundInvoker {
    /**
     * 启动流程.<br/>
     */
    void start();

    /**
     * 终止流程.<br/>
     */
    void shutdown();

    /**
     * 用于获取返回值<br/>
     *
     * @return
     */
    <T extends TransHandlerContext> T getContext();
}
