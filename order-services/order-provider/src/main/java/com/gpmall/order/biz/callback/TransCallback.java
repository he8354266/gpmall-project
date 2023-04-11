package com.gpmall.order.biz.callback;

import com.gpmall.order.biz.context.TransHandlerContext;

/**
 * @Description //TODO
 * @Date 2023/4/11 13:57
 * @Author hy
 **/
public interface TransCallback {
    void onDone(TransHandlerContext context);
}
