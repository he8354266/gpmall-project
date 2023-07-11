package com.gpmall.pay.services;

import com.gpmall.pay.biz.abs.BasePayment;
import com.gupaoedu.pay.PayCoreService;
import com.gupaoedu.pay.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description //TODO
 * @Date 2023/7/4 10:36
 * @Author hy
 **/
@Slf4j
@Service(cluster = "failover")
public class PayCoreServiceImpl implements PayCoreService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaymentResponse execPay(PaymentRequest request) {
        PaymentResponse paymentResponse = new PaymentResponse();
        try {
//            BasePayment.paymentMap().get(request.getPayChannel()).process().var
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public PaymentNotifyResponse paymentResultNotify(PaymentNotifyRequest request) {
        return null;
    }

    @Override
    public RefundResponse execRefund(RefundRequest refundRequest) {
        return null;
    }
}
