package com.gpmall.pay.biz.abs;

import com.gpmall.commons.result.AbstractRequest;
import com.gpmall.commons.result.AbstractResponse;
import com.gpmall.commons.tool.exception.BizException;
import com.gupaoedu.pay.dto.PaymentNotifyRequest;

/**
 * @Description //TODO
 * @Date 2023/7/4 10:51
 * @Author hy
 **/
public interface Payment {
    /**
     * 发起交易执行的过程
     *
     * @param request
     * @return
     * @throws BizException
     */
    <T extends AbstractResponse> T process(AbstractRequest request) throws BizException;

    /**
     * 完成交易结果的处理
     *
     * @param request
     * @return
     * @throws BizException
     */
    <T extends AbstractResponse> T completePayment(PaymentNotifyRequest request) throws BizException;
}
