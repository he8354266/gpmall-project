package com.gpmall.order.biz.context;

import com.gpmall.order.biz.convert.TransConvert;
import lombok.Data;

/**
 * @Description //TODO
 * @Date 2023/4/6 10:12
 * @Author hy
 **/
@Data
public class AbsTransHandlerContext implements TransHandlerContext {
    private String orderId;

    private TransConvert convert = null;
}
