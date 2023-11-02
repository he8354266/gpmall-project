package com.design.appleyk.DAM2_抽象工厂.Mouse;

import com.design.appleyk.DAM2_抽象工厂.DAM2.ProduceMouse;

/**
 * @Description //TODO
 * @Date 2023/10/30 15:28
 * @Author hy
 **/
public class LuoJiMouse implements ProduceMouse {
    @Override
    public void produceMouse(String name, String type) {
        System.out.println("罗技鼠标 -- "+name+","+type);
    }
}
