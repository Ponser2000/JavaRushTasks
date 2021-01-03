package com.javarush.task.task33.task3310;

/**
 * @author Sergey Ponomarev on 03.01.2021
 * @project JavaRushTasks/com.javarush.task.task33.task3310
 */
public class ExceptionHandler {
  public static void log(Exception e){
    System.out.println("ExceptionHandler message: " + e.getMessage());
  }

}
