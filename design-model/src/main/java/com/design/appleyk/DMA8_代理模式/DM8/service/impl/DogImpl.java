package com.design.appleyk.DMA8_代理模式.DM8.service.impl;

import com.design.appleyk.DMA8_代理模式.DM8.service.CommodityService;

/**
 * @Description //TODO
 * @Date 2023/11/2 14:20
 * @Author hy
 **/
public class DogImpl implements CommodityService {
    @Override
    public void getCommodity(String name) {
        System.out.println("宠物狗获得商品："+name);
    }
}
