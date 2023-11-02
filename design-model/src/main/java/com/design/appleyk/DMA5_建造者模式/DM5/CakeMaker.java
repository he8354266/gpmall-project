package com.design.appleyk.DMA5_建造者模式.DM5;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

/**
 * @Description //TODO
 * @Date 2023/11/1 11:39
 * @Author hy
 **/
public class CakeMaker implements CakeBuilder {
    private String name;

    private Cake cake = new Cake();

    public CakeMaker(String name) {
        this.name = name;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void knead() {
        cake.addProcess("揉面 -- 软软的，滑滑的");
    }

    @Override
    public void ferment() {
        cake.addProcess("发酵 -- 酵一酵");
    }

    @Override
    public void bake(int minutes) {
        cake.addProcess("烘烤 -- "+minutes+"分钟");
    }

    @Override
    public Cake getCake() {
        return this.cake;
    }
}
