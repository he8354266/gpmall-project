package com.gpmall.order.biz.callback;

import com.gpmall.order.biz.context.TransHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO
 * @Date 2023/4/11 13:58
 * @Author hy
 **/
@Component
@Slf4j
public class SendEmailCallback implements TransCallback {
    @Override
    public void onDone(TransHandlerContext context) {
        log.info("订单下单成功后，会发送邮件");
    }
}
