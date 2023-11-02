package com.design.appleyk.DAM2_抽象工厂;

import com.design.appleyk.DAM2_抽象工厂.DAM2.ProduceKeyBord;
import com.design.appleyk.DAM2_抽象工厂.DAM2.ProduceMouse;
import com.design.appleyk.DAM2_抽象工厂.Factory.LianXiang01Factory;
import com.design.appleyk.DAM2_抽象工厂.Factory.LianXiang02Factory;

/**
 * @Description //TODO
 * @Date 2023/10/30 15:32
 * @Author hy
 **/
public class AFactoryTest {
    public static void main(String[] args) {
        LianXiang01Factory lianXiang01Factory = new LianXiang01Factory();
        ProduceKeyBord produceKeyBord = lianXiang01Factory.createKeyBord();
        produceKeyBord.produceKeyBord("M550", "黑色");
        ProduceMouse produceMouse = lianXiang01Factory.createMouse();
        produceMouse.produceMouse("M590", "有线");


        LianXiang02Factory lianXiang02Factory = new LianXiang02Factory();
        ProduceKeyBord produceKeyBord1 = lianXiang02Factory.createKeyBord();
        produceKeyBord1.produceKeyBord("M550", "黑色");
        ProduceMouse produceMouse1 = lianXiang02Factory.createMouse();
        produceMouse1.produceMouse("M590", "无线");
    }
}
