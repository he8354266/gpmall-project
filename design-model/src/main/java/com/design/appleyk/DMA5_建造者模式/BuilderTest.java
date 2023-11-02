package com.design.appleyk.DMA5_建造者模式;

import com.design.appleyk.DMA5_建造者模式.DM5.Cake;
import com.design.appleyk.DMA5_建造者模式.DM5.CakeMaker;
import com.design.appleyk.DMA5_建造者模式.DM5.CakeSeller;

/**
 * @Description //TODO
 * @Date 2023/11/1 13:53
 * @Author hy
 **/
public class BuilderTest {
    public static void main(String[] args) {
        CakeMaker cakeMaker = new CakeMaker("li");

        CakeSeller cakeSeller = new CakeSeller();
        Cake cake = cakeSeller.sell(cakeMaker);

        cake.show();
    }
}
