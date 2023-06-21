package com.gpmall.search;

import com.gpmall.commons.tool.exception.BaseBusinessException;

/**
 * @Description //TODO
 * @Date 2023/6/21 9:24
 * @Author hy
 **/
public class SearchException extends BaseBusinessException {
    public SearchException() {

    }

    public SearchException(String errorCode) {
        super(errorCode);
    }

    public SearchException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static SearchException create(String errorCode, String message) {
        return new SearchException(errorCode, message);
    }
}
