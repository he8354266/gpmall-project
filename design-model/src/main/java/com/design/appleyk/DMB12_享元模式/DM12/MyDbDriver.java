package com.design.appleyk.DMB12_享元模式.DM12;

/**
 * @Description //TODO
 * @Date 2023/11/6 9:39
 * @Author hy
 **/
public class MyDbDriver extends AbstractFlyWeight {
    private String driverName;

    public MyDbDriver(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public void connection() {
        System.out.println(this.driverName);
    }
}
