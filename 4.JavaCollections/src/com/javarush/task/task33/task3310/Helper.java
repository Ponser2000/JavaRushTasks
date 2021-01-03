package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author Sergey Ponomarev on 03.01.2021
 * @project JavaRushTasks/com.javarush.task.task33.task3310
 */
public class Helper {
  public static String generateRandomString(){
    SecureRandom random = new SecureRandom();
    return new BigInteger(130, random).toString(36);
  }

  public static void printMessage(String message){
    System.out.println(message);
  }

}
