package com.design.appleyk.DMB13_策略模式.DM13.公式计算;

/**
 * @Description //TODO
 * @Date 2023/11/6 14:22
 * @Author hy
 **/
public class Sub implements ICalculator {

  @Override
  public double calculate(String formula) {
    double[] valArray = CalculatorHelper.getValArray(formula, "-");
    return valArray[0] - valArray[1];
  }
}
