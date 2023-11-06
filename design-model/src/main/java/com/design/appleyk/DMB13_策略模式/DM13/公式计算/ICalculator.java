package com.design.appleyk.DMB13_策略模式.DM13.公式计算;

/**
 * @Description //TODO
 * @Date 2023/11/6 14:13
 * @Author hy
 **/
public interface ICalculator {

  /**
   * <p>根据公式字符串，计算得出值</p>
   *
   * @param formula 公式
   * @return 值
   */
  double calculate(String formula);
}
