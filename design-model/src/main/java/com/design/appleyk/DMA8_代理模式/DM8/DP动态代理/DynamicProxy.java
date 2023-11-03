package com.design.appleyk.DMA8_代理模式.DM8.DP动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description //TODO
 * @Date 2023/11/2 14:26
 * @Author hy
 **/
public class DynamicProxy implements InvocationHandler {
    private Object targetObj;

    public DynamicProxy(Object target) {
        targetObj = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是UU跑腿的工作人员，我去超市帮助客户取商品：" + args[0]);
        Object object = method.invoke(targetObj, args);
        System.out.println("拿到被代理对象调用的方法名：" + method.getName() + ",方法参数个数：" + method.getParameterCount());
        System.out.println("商品已成功转交给被代理的对象，期待对象好评");
        return object;
    }
}
