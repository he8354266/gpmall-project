package com.design.appleyk.DMA9_外观模式.DM9.ModuleA;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:51
 * @Author hy
 **/
public class FacadeA {
    private SubSystemA subSystemA;
    private SubSystemB subSystemB;

    public FacadeA() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
    }

    public void initialize() {
        subSystemA.initSystem();
        subSystemB.loadDatas();
    }
}
