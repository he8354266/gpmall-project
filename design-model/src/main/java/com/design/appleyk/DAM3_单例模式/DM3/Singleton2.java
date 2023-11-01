package com.design.appleyk.DAM3_单例模式.DM3;

/**
 * @Description //TODO
 * @Date 2023/10/30 16:22
 * @Author hy
 **/
public class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 instance = null;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
