package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergey Ponomarev on 07.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613
 */
public class ConsoleHelper {
  private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

  public static void writeMessage(String message){
    System.out.println(message);
  }

  public static String readString() throws InterruptOperationException{
    try {
      String result = bis.readLine();
      if ("exit".equals(result.toLowerCase())) {
        throw new InterruptOperationException();
      }
      return result;
    } catch (IOException e) {
      /* NOP */
    }
    return null;
  }

  public static String askCurrencyCode() throws InterruptOperationException{
    writeMessage("Введите код валюды (XXX): ");
    Pattern p = Pattern.compile("^[A-zА-яЁё]+$");
    while(true) {
      String code = readString();
      Matcher m = p.matcher(code);
      if (code.length() != 3 || ! m.find()) {
        writeMessage("Повторите ввод:");
        continue;
      }
      return code.toUpperCase();
    }
  }

  public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
    writeMessage("Введите через пробел номинал и количество купюр:");
    String[] dengi;
    while(true) {
      String inputNominalAndCount = readString();
      inputNominalAndCount = inputNominalAndCount.replaceAll("\\s+"," ");
      dengi = inputNominalAndCount.split(" ");
      if (dengi.length != 2) {
        writeMessage("Повторите ввод:");
        continue;
      }
      Pattern p = Pattern.compile("^\\d+$");
      Matcher m1 = p.matcher(dengi[0]);
      Matcher m2 = p.matcher(dengi[1]);
      if( ! (m1.find() && m2.find()) ) {
        writeMessage("Повторите ввод:");
        continue;
      }
      if( Integer.parseInt(dengi[0]) < 1 && Integer.parseInt(dengi[1]) < 1) {
        writeMessage("Повторите ввод:");
        continue;
      }

      return dengi;
    }
  }

  public static Operation askOperation() throws InterruptOperationException {
    while (true) {
      ConsoleHelper.writeMessage("Пожалуйста, выберите доступную операцию или наберите 'EXIT' для завершения работы");
      ConsoleHelper.writeMessage("\t 1 - operation.INFO");
      ConsoleHelper.writeMessage("\t 2 - operation.DEPOSIT");
      ConsoleHelper.writeMessage("\t 3 - operation.WITHDRAW");
      ConsoleHelper.writeMessage("\t 4 - operation.EXIT");
      Integer i = Integer.parseInt(ConsoleHelper.readString().trim());
      try {
        return Operation.getAllowableOperationByOrdinal(i);
      } catch (IllegalArgumentException e) {
        ConsoleHelper.writeMessage("Не корректный ввод. Повторите.");
      }
    }
  }

}
