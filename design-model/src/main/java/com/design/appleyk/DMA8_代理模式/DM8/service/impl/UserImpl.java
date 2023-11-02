package com.design.appleyk.DMA8_代理模式.DM8.service.impl;

import com.design.appleyk.DMA8_代理模式.DM8.service.CommodityService;

/**
 * @Description //TODO
 * @Date 2023/11/2 14:25
 * @Author hy
 **/
public class UserImpl implements CommodityService {
    @Override
    public void getCommodity(String name) {
        System.out.println("用户获得商品：" + name);
    }
}
