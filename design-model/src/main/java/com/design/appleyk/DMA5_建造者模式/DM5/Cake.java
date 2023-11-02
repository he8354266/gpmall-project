package com.design.appleyk.DMA5_建造者模式.DM5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/11/1 11:31
 * @Author hy
 **/
public class Cake {
    private List<String> parts = new ArrayList<>();

    public Cake() {
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public void addProcess(String part) {
        this.parts.add(part);
    }

    public void show() {
        System.out.println("蛋糕包含的配件如下：");
        for (String part : parts) {
            System.out.print(part);
        }
    }

}