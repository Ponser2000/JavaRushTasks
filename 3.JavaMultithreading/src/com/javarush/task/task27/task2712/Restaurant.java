package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

/**
 * @author Sergey Ponomarev on 16.12.2020
 * JavaRushTasks/com.javarush.task.task27.task2712.kitchen
 */

public class Restaurant {

  public static void main(String[] args) {
    Tablet tablet = new Tablet(1);
    tablet.createOrder();
    tablet.createOrder();
    tablet.createOrder();
    tablet.createOrder();
  }

}
