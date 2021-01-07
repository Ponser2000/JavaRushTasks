package com.javarush.task.task26.task2613;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Sergey Ponomarev on 07.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613.exception
 */
public class CurrencyManipulator {
  private String currencyCode;
  private Map<Integer, Integer> denominations;

  public CurrencyManipulator(String currencyCode) {
    this.currencyCode = currencyCode;
    this.denominations = new TreeMap<>();
  }

  public String getCurrencyCode() {
    return currencyCode;
  }
}
