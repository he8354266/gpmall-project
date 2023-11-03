package com.design.appleyk.DMA9_外观模式.DM9.ModuleA;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:50
 * @Author hy
 **/
public class SubSystemA {
    public void initSystem() {
        System.out.println("人工智能系统正在启动，请您稍等.... =====>" + this);
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("等待" + (i + 1) + "s");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getClass() + "," + ex.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "人工智能系统，模块A，子系统A，主要负责启动系统";
    }
}
