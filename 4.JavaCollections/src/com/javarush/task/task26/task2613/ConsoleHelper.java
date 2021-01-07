package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sergey Ponomarev on 07.01.2021
 * @project JavaRushTasks/com.javarush.task.task26.task2613
 */
public class ConsoleHelper {
  private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

  public static void writeMessage(String message){
    System.out.println(message);
  }

  public static String readString(){
    try {
      String result = bis.readLine();
      return result;
    } catch (IOException e) {
      /* NOP */
    }
    return null;
  }

}
