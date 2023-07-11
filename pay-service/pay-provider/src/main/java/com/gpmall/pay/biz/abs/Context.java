package com.gpmall.pay.biz.abs;

import java.util.SortedMap;

/**
 * @Description //TODO
 * @Date 2023/7/4 11:08
 * @Author hy
 **/
public class Context {
    public Context() {
        super();
    }

    SortedMap<String, Object> sParaTemp;

    public SortedMap<String, Object> getsParaTemp() {
        return sParaTemp;
    }

    public void setsParaTemp(SortedMap<String, Object> sParaTemp) {
        this.sParaTemp = sParaTemp;
    }

}
