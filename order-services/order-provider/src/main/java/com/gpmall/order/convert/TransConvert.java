package com.gpmall.order.convert;

import com.gpmall.commons.result.AbstractRequest;
import com.gpmall.commons.result.AbstractResponse;
import com.gpmall.order.context.TransHandlerContext;

/**
 * @Description //TODO
 * @Date 2023/4/6 10:19
 * @Author hy
 **/
public interface TransConvert {
    /**
     * 请求转上下文
     *
     * @param req
     * @return
     */
    TransHandlerContext convertRequest2Ctx(AbstractRequest req, TransHandlerContext context);

    /**
     * 上下文转应答
     *
     * @param ctx
     * @return
     */
    AbstractResponse convertCtx2Respond(TransHandlerContext ctx);
}
