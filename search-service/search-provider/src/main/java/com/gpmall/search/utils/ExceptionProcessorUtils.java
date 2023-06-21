package com.gpmall.search.utils;

import com.gpmall.commons.result.AbstractResponse;
import com.gpmall.commons.tool.exception.ExceptionUtil;
import com.gpmall.search.consts.SearchRetCode;

/**
 * @Description //TODO
 * @Date 2023/6/21 17:22
 * @Author hy
 **/
public class ExceptionProcessorUtils {
    public static void wrapperHandlerException(AbstractResponse response, Exception e) {
        try {
            ExceptionUtil.handlerException4biz(response, e);
        } catch (Exception ex) {
            response.setMsg(SearchRetCode.SYSTEM_ERROR.getMsg());
            response.setCode(SearchRetCode.STRING_EMPTY.getCode());
        }

    }
}
