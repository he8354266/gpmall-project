package com.gpmall.order.biz.factory;

import com.gpmall.commons.result.AbstractRequest;
import com.gpmall.order.biz.TransOutboundInvoker;
import com.gpmall.order.biz.context.TransHandlerContext;
import com.gpmall.order.biz.convert.TransConvert;
import com.gpmall.order.biz.handler.DefaultTransPipeline;
import com.gpmall.order.biz.handler.TransPipeline;

/**
 * @Description //TODO
 * @Date 2023/4/7 9:32
 * @Author hy
 **/
public abstract class AbstranctTransPipelineFactory<T extends AbstractRequest> implements TransPipelineFactory<T> {
    @Override
    public final TransOutboundInvoker buid(T obj) {
        //创建转换器
        TransConvert convert = createConvert();

        return null;
    }

    protected abstract void doBuild(TransPipeline pipeline);

    protected TransPipeline createPipeline(TransHandlerContext context) {
        return new DefaultTransPipeline(context);
    }



    protected abstract TransHandlerContext createContext();

    protected abstract TransConvert createConvert();

}
