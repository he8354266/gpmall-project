package com.gpmall.order.biz.handler;

import com.gpmall.order.biz.callback.TransCallback;
import lombok.Data;

/**
 * @Description //TODO
 * @Date 2023/4/11 13:47
 * @Author hy
 **/
@Data
public abstract class AbstractTransHandler implements TransHandler {
    public static final String DEFAULT = "default";

    public TransCallback getTransCallback() {
        return null;
    }
}
