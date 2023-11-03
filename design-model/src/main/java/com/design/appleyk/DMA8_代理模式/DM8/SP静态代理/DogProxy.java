package com.design.appleyk.DMA8_代理模式.DM8.SP静态代理;

import com.design.appleyk.DMA8_代理模式.DM8.service.CommodityService;
import com.design.appleyk.DMA8_代理模式.DM8.service.impl.DogImpl;

/**
 * @Description //TODO
 * @Date 2023/11/2 15:23
 * @Author hy
 **/
public class DogProxy implements CommodityService {
    private DogImpl dog;

    public DogProxy() {
        dog = new DogImpl();
    }

    @Override
    public void getCommodity(String name) {
        System.out.println("我是UU跑腿的工作人员，我去超市帮助狗狗取狗粮："+name);
        dog.getCommodity(name);
        System.out.println("商品已成功交给狗狗，期待狗狗的主人好评");
    }
}
