package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;
import java.util.List;

/**
 * @author Sergey Ponomarev on 16.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.kitchen
 */

public class Order {

  private final Tablet tablet;
  protected List<Dish> dishes;

  public Order(Tablet tablet) {
    this.tablet = tablet;
  }

}
