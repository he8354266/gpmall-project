package com.design.appleyk.DMA8_代理模式.DM8.NP非代理;

import com.design.appleyk.DMA8_代理模式.DM8.service.CommodityService;

/**
 * @Description //TODO
 * @Date 2023/11/2 15:19
 * @Author hy
 **/
public class UserOwn implements CommodityService {
    @Override
    public void getCommodity(String name) {
        goSuperMarket();
        choose(name);
        pay();
        System.out.println("用户获得商品："+name);
        goHome();
    }

    private void goSuperMarket() {
        System.out.println("去超市");
    }

    private void choose(String name) {
        System.out.println("选商品: " + name);
    }

    private void pay() {
        System.out.println("付钱");
    }

    private void goHome() {
        System.out.println("买完商品，回家");
    }
}
