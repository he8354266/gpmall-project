package com.gpmall.order.biz.handler;

import com.gpmall.order.biz.TransOutboundInvoker;

/**
 * @Description //TODO
 * @Date 2023/4/11 9:14
 * @Author hy
 **/
public interface TransPipeline extends TransOutboundInvoker {
    void addFirst(TransHandler... handler);

    void addLast(TransHandler... handler);
}
