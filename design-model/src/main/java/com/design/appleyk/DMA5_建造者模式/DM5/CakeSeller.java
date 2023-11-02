package com.design.appleyk.DMA5_建造者模式.DM5;

/**
 * @Description //TODO
 * @Date 2023/11/1 13:50
 * @Author hy
 **/
public class CakeSeller {
    public CakeSeller() {
    }

    public Cake sell(CakeBuilder cakeBuilder) {
        cakeBuilder.knead();
        cakeBuilder.ferment();
        cakeBuilder.bake(30);
        return cakeBuilder.getCake();
    }
}
