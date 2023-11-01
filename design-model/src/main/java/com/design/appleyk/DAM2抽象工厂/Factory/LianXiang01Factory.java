package com.design.appleyk.DAM2抽象工厂.Factory;

import com.design.appleyk.DAM2抽象工厂.DAM2.AComputerFactory;
import com.design.appleyk.DAM2抽象工厂.DAM2.ProduceKeyBord;
import com.design.appleyk.DAM2抽象工厂.DAM2.ProduceMouse;
import com.design.appleyk.DAM2抽象工厂.KeyBoard.LeiBoKeyBord;
import com.design.appleyk.DAM2抽象工厂.Mouse.LeiBoMouse;

/**
 * @Description //TODO
 * @Date 2023/10/30 15:24
 * @Author hy
 **/
public class LianXiang01Factory implements AComputerFactory {
    @Override
    public ProduceKeyBord createKeyBord() {
        return new LeiBoKeyBord();
    }

    @Override
    public ProduceMouse createMouse() {
        return new LeiBoMouse();
    }
}
