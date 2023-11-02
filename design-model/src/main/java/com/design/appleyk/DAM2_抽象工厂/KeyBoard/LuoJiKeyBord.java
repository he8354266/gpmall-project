package com.design.appleyk.DAM2_抽象工厂.KeyBoard;

import com.design.appleyk.DAM2_抽象工厂.DAM2.ProduceKeyBord;

/**
 * @Description //TODO
 * @Date 2023/10/30 15:27
 * @Author hy
 **/
public class LuoJiKeyBord implements ProduceKeyBord {
    @Override
    public void produceKeyBord(String name, String color) {
        System.out.println("罗技键盘 -- "+name+","+color);
    }
}
