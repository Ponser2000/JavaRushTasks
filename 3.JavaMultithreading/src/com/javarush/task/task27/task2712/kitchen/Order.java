package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import java.io.IOException;
import java.util.List;

/**
 * @author Sergey Ponomarev on 16.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.kitchen
 */

public class Order {

  private final Tablet tablet;
  protected List<Dish> dishes;

  public Order(Tablet tablet) throws IOException {
    this.tablet = tablet;
    this.dishes = ConsoleHelper.getAllDishesForOrder();
  }

  @Override
  public String toString() {
    if (dishes.isEmpty()) return "";
    return "Your order: " + dishes.toString() + " of " + tablet.toString();
  }

}
