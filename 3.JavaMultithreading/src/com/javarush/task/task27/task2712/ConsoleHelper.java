package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Ponomarev on 17.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712
 */

public class ConsoleHelper {
  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static String GREATING_MSG = "Please, make your choice";
  private static String WARNING_MSG = "Unfortunately, there is no such dish on the menu.";

  public static void writeMessage(String message) {
    System.out.println(message);
  }

  public static String readString() throws IOException{
    return reader.readLine();
  }

  public static List<Dish> getAllDishesForOrder() throws IOException {
    writeMessage(Dish.allDishesToString());
    writeMessage(GREATING_MSG);

    List<Dish> result = new ArrayList<>();

    String wishes = null;
    while (!(wishes = readString()).equals("exit")) {
      try {
        result.add(Dish.valueOf(wishes));
      } catch (IllegalArgumentException | NullPointerException e) {
        writeMessage(WARNING_MSG);
      }
    }
    return result;
  }

}
