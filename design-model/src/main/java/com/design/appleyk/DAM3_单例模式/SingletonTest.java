package com.design.appleyk.DAM3_单例模式;

import com.design.appleyk.DAM3_单例模式.DM3.Singleton1;
import com.design.appleyk.DAM3_单例模式.DM3.Singleton2;

/**
 * @Description //TODO
 * @Date 2023/10/31 14:14
 * @Author hy
 **/
public class SingletonTest {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();

        Singleton2 singleton2 = Singleton2.getInstance();

    }
}
