package com.design.appleyk.DAM2_抽象工厂.DAM2;

/**
 * @Description //TODO
 * @Date 2023/10/30 15:16
 * @Author hy
 **/
public abstract interface AComputerFactory {
    ProduceKeyBord createKeyBord();

    ProduceMouse createMouse();
}
