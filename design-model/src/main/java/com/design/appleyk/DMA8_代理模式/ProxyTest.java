package com.design.appleyk.DMA8_代理模式;

import com.design.appleyk.DMA8_代理模式.DM8.NP非代理.UserOwn;
import com.design.appleyk.DMA8_代理模式.DM8.ProxyFactory;
import com.design.appleyk.DMA8_代理模式.DM8.VP虚拟代理.Secretary;
import com.design.appleyk.DMA8_代理模式.DM8.service.CommodityService;
import com.design.appleyk.DMA8_代理模式.DM8.service.impl.DogImpl;
import com.design.appleyk.DMA8_代理模式.DM8.service.impl.UserImpl;

/**
 * @Description //TODO
 * @Date 2023/11/2 15:57
 * @Author hy
 **/
public class ProxyTest {
    public static void main(String[] args) {
        int second = 5;
        // 4、使用虚拟代理
        useVirtualProxy(second);
    }

    private static void noProxy(String uName) {
        UserOwn userOwn = new UserOwn();
        userOwn.getCommodity(uName);
    }

    private static void useStaticProxy(String uName, String dName) {
        ProxyFactory.getUserProxy().getCommodity(dName);
        System.out.println("===========分割线");
        ProxyFactory.getUserProxy().getCommodity(uName);
        System.out.println("===========分割线");
    }

    private static void useDynamicProxy(String uName, String dName) {
        CommodityService userProxy = (CommodityService) ProxyFactory.getDynProxy(new UserImpl());
        userProxy.getCommodity(uName);

        CommodityService dogProxy = (CommodityService) ProxyFactory.getDynProxy(new DogImpl());
        dogProxy.getCommodity(dName);
    }

    public static void useVirtualProxy(int second) {
        Secretary secretary = new Secretary();
        secretary.addDeal("hetong1");
        secretary.addDeal("hetong2");
        secretary.sign();

        secretary.initLeader(second);
        secretary.addDeal("hetong3");
        secretary.addDeal("hetong4");
        secretary.sign();
    }
}
