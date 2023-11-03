package com.design.appleyk.DMA9_外观模式;

import com.design.appleyk.DMA9_外观模式.DM9.ModuleA.SubSystemA;
import com.design.appleyk.DMA9_外观模式.DM9.ModuleA.SubSystemB;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:59
 * @Author hy
 **/
public class FacadeTest {
    public static void main(String[] args) {
        useModuleA();
    }

    private static void useModuleA() {
        SubSystemA subSystemA = new SubSystemA();
        SubSystemB subSystemB = new SubSystemB();
        subSystemA.initSystem();
        subSystemB.loadDatas();
    }
}
