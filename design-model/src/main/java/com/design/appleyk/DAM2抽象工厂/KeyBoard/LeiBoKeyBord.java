package com.design.appleyk.DAM2抽象工厂.KeyBoard;

import com.design.appleyk.DAM2抽象工厂.DAM2.ProduceKeyBord;

/**
 * @Description //TODO
 * @Date 2023/10/30 15:25
 * @Author hy
 **/
public class LeiBoKeyBord implements ProduceKeyBord {
    @Override
    public void produceKeyBord(String name, String color) {
        System.out.println("雷柏键盘 -- "+name+","+color);
    }
}
