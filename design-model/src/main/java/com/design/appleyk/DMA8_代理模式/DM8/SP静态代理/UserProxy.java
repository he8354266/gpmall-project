package com.design.appleyk.DMA8_代理模式.DM8.SP静态代理;

import com.design.appleyk.DMA8_代理模式.DM8.service.CommodityService;
import com.design.appleyk.DMA8_代理模式.DM8.service.impl.UserImpl;

/**
 * @Description //TODO
 * @Date 2023/11/2 15:27
 * @Author hy
 **/
public class UserProxy implements CommodityService {
    private UserImpl user;

    public UserProxy() {
        user = new UserImpl();
    }

    @Override
    public void getCommodity(String name) {
        System.out.println("我是UU跑腿的工作人员，我去超市帮助用户取商品："+name);
        user.getCommodity(name);
        System.out.println("商品已成功交给用户，期待用户好评");
    }
}
