package com.design.appleyk.DMB12_享元模式.DM12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description //TODO
 * @Date 2023/11/6 9:39
 * @Author hy
 **/
public class DbDriverFactory {

  private Map<String, Object> driverMap;

  private List<MyDbDriver> dbDrivers = new ArrayList<>();

  public DbDriverFactory() {
    driverMap = new HashMap<>();
  }

  public MyDbDriver getDbDriver(String driverName) {
    MyDbDriver dbDriver;
    if (this.driverMap.containsKey(driverName)) {
      System.out.println(driverName + "存在");
      dbDriver = (MyDbDriver) driverMap.get(driverName);
      this.dbDrivers.add(dbDriver);
      return dbDriver;
    }
    dbDriver = new MyDbDriver(driverName);
    this.driverMap.put(driverName, dbDriver);
    this.dbDrivers.add(dbDriver);
    return dbDriver;
  }

  public int size() {
    return driverMap.size();
  }

  public void showConns() {
    this.dbDrivers.forEach(d->{d.connection();});
  }
}
