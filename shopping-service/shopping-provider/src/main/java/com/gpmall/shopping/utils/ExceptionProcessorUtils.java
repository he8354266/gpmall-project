package com.gpmall.shopping.utils;

import com.gpmall.commons.result.AbstractResponse;
import com.gpmall.commons.tool.exception.ExceptionUtil;
import com.gpmall.shopping.constans.ShoppingRetCode;

/**
 * @Description //TODO
 * @Date 2023/1/28 17:14
 * @Author hy
 **/
public class ExceptionProcessorUtils {
    public static void wrapperHandlerException(AbstractResponse response, Exception e) {
        try {
            ExceptionUtil.handlerException4biz(response, e);
        } catch (Exception ex) {
            response.setMsg(ShoppingRetCode.SYSTEM_ERROR.getMessage());
            response.setCode(ShoppingRetCode.SYSTEM_ERROR.getCode());
        }
    }
}
