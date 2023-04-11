package com.gpmall.order.biz.factory;

import com.gpmall.order.biz.TransOutboundInvoker;

/**
 * @Description //TODO
 * @Date 2023/4/7 9:13
 * @Author hy
 **/
public interface TransPipelineFactory<T> {
    TransOutboundInvoker buid(T obj);
}
