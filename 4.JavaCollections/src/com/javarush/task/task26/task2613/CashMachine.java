package com.javarush.task.task26.task2613;

import java.util.Locale;

/**
 * @author Sergey Ponomarev on 07.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613
 */
public class CashMachine {

  public static void main(String[] args) {
    Locale.setDefault(Locale.ENGLISH);
    String currencyCode = ConsoleHelper.askCurrencyCode();
    String[] digits = ConsoleHelper.getValidTwoDigits(currencyCode);

    int denomination = Integer.parseInt(digits[0]);
    int count = Integer.parseInt(digits[1]);

    CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
    currencyManipulator.addAmount(denomination,count);

    System.out.println(currencyManipulator.getTotalAmount());
  }
}
