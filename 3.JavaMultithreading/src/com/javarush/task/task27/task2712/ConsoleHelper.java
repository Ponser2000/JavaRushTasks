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
  private static String GREATING_MSG = "Please choose a dish from the list:";
  private static String WARNING_MSG = " hasn't been detected";
  private static String SUCCEED_MSG = " has been successfully added to your order";

  public static void writeMessage(String message) {
    System.out.println(message);
  }

  public static String readString() throws IOException{
    return reader.readLine();
  }

  public static List<Dish> getAllDishesForOrder() throws IOException {
    writeMessage(Dish.allDishesToString());
    writeMessage(GREATING_MSG);

    List<Dish> dishes = new ArrayList<>();

    String dishName = null;
    while (!(dishName = readString()).trim().equals("exit")) {
      try {
        Dish dish = Dish.valueOf(dishName);
        dishes.add(dish);
        writeMessage(dishName + SUCCEED_MSG);
      } catch (IllegalArgumentException | NullPointerException e) {
        writeMessage(dishName + WARNING_MSG);
      }
    }
    return dishes;
  }

}
