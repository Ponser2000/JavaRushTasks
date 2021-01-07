package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Ponomarev on 07.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.exception
 */
public class CurrencyManipulatorFactory {

  private CurrencyManipulatorFactory currencyManipulatorFactory;
  private static Map<String, CurrencyManipulator> map = new HashMap<>();

  private CurrencyManipulatorFactory(){}

  public CurrencyManipulatorFactory getInstance(){
    if (currencyManipulatorFactory == null) {
      currencyManipulatorFactory = new CurrencyManipulatorFactory();
    }
    return currencyManipulatorFactory;
  }

  public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
    currencyCode = currencyCode.toUpperCase();
    if (!map.containsKey(currencyCode)) {
      CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
      map.put(manipulator.getCurrencyCode(), manipulator);
    }
    return map.get(currencyCode);
  }

}
