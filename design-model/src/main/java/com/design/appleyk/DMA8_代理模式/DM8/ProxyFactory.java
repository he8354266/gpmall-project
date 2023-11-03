package com.design.appleyk.DMA8_代理模式.DM8;

import com.design.appleyk.DMA8_代理模式.DM8.DP动态代理.DynamicProxy;
import com.design.appleyk.DMA8_代理模式.DM8.SP静态代理.DogProxy;
import com.design.appleyk.DMA8_代理模式.DM8.SP静态代理.UserProxy;
import com.design.appleyk.DMA8_代理模式.DM8.service.CommodityService;

import java.lang.reflect.Proxy;

/**
 * @Description //TODO
 * @Date 2023/11/2 15:29
 * @Author hy
 **/
public  class ProxyFactory {
    /**
     * 获取一个静态用户代理类对象
     */
    public static CommodityService getUserProxy() {
        return new UserProxy();
    }

    public static CommodityService getDogProxy() {
        return new DogProxy();
    }

    public static Object getDynProxy(Object target) {
        DynamicProxy handler = new DynamicProxy(target);
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        return instance;
    }
}
