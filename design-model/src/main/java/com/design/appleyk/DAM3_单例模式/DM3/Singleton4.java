package com.design.appleyk.DAM3_单例模式.DM3;

/**
 * @Description //TODO
 * @Date 2023/10/31 13:56
 * @Author hy
 **/
public class Singleton4 {
    private Singleton4() {
    }

    private static class  SingletonFactory {
        private static Singleton4 singleton4 = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return SingletonFactory.singleton4;
    }
}
