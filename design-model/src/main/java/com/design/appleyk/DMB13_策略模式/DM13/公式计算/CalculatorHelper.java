package com.design.appleyk.DMB13_策略模式.DM13.公式计算;

/**
 * @Description //<p>计算辅助类，主要提取公式中的数数组</p>
 * @Date 2023/11/6 14:14
 * @Author hy
 **/
public class CalculatorHelper {

  public static double[] getValArray(String formula, String splitChar) {
    String[] array = formula.trim().split(splitChar);
    double arrayDouble[] = new double[2];
    arrayDouble[0] = Double.parseDouble(array[0]);
    arrayDouble[1] = Double.parseDouble(array[1]);
    return arrayDouble;
  }
}
