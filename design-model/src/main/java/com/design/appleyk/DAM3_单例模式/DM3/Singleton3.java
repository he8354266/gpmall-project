package com.design.appleyk.DAM3_单例模式.DM3;

/**
 * @Description //TODO
 * @Date 2023/10/31 13:48
 * @Author hy
 **/
public class Singleton3 {
    private Singleton3() {
    }

    private static Singleton3 instance = null;

    public static Singleton3 getInstance() {
        if(instance == null){
            synchronized (Singleton3.class){
                if(instance==null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
