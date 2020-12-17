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
    ConsoleHelper.writeMessage(toString());
  }

  @Override
  public String toString() {
    String result ="";
    if (dishes.size() == 0) return result;
    result += "Your order: [" + dishes.get(0);

    for(int i = 1; i < dishes.size(); i++) {
      result += ", " + dishes.get(i).name();
    }
    result += "]";
    return result;
  }

}
