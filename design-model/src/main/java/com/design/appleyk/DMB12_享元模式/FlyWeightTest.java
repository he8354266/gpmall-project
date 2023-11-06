package com.design.appleyk.DMB12_享元模式;

import com.design.appleyk.DMB12_享元模式.DM12.DbDriverFactory;
import com.design.appleyk.DMB12_享元模式.DM12.MyDbDriver;

/**
 * @Description //TODO
 * @Date 2023/11/6 11:20
 * @Author hy
 **/
public class FlyWeightTest {

  public static void main(String[] args) {
    DbDriverFactory factory  = new DbDriverFactory();
    MyDbDriver driver1  = factory.getDbDriver("mysql");
    MyDbDriver driver2 = factory.getDbDriver("mongodb");
    MyDbDriver driver3 = factory.getDbDriver("mysql");
    MyDbDriver driver4 = factory.getDbDriver("postgresql");
    MyDbDriver driver5 = factory.getDbDriver("oracle");
    factory.showConns();
  }
}
