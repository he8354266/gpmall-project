package com.design.appleyk.DMA9_外观模式.DM9.ModuleB;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:55
 * @Author hy
 **/
public class FacadeB {
    private SubSystemC subSystemC;
    private SubSystemD subSystemD;

    public FacadeB() {
        subSystemC = new SubSystemC();
        subSystemD = new SubSystemD();
    }

    public void work() {
        this.subSystemC.sayHello();
        this.subSystemD.working();
    }
}
