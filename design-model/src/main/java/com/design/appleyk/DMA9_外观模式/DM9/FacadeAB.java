package com.design.appleyk.DMA9_外观模式.DM9;

import com.design.appleyk.DMA9_外观模式.DM9.ModuleA.FacadeA;
import com.design.appleyk.DMA9_外观模式.DM9.ModuleB.FacadeB;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:57
 * @Author hy
 **/
public class FacadeAB {
    private FacadeA facadeA;
    private FacadeB facadeB;

    public FacadeAB() {
        this.facadeA = new FacadeA();
        this.facadeB = new FacadeB();
    }

    public void startSystem() {
        this.facadeA.initialize();
        this.facadeB.work();
    }

}
