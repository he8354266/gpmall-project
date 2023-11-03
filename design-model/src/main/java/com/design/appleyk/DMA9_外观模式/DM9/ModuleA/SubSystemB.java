package com.design.appleyk.DMA9_外观模式.DM9.ModuleA;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:51
 * @Author hy
 **/
public class SubSystemB {
    public void loadDatas() {
        System.out.println("人工智能系统已经启动，正在加载数据 =====>" + this);
        System.out.println(".........");
        System.out.println("数据已完成加载");
    }

    @Override
    public String toString() {
        return "人工智能系统，模块A，子系统B，主要负责加载数据";
    }
}
