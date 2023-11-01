package com.design.appleyk.DAM3_单例模式.DM3;

/**
 * @Description //单例模式 -- 非线程安全
 * @Date 2023/10/30 16:15
 * @Author hy
 **/
public class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
