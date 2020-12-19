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

  public final Tablet tablet;
  protected List<Dish> dishes;

  public Order(Tablet tablet) throws IOException {
    this.tablet = tablet;
    this.dishes = ConsoleHelper.getAllDishesForOrder();
    ConsoleHelper.writeMessage(toString());
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    if (dishes.size() == 0) return result.toString();
    result.append("Your order: [" + dishes.get(0));

    for (int i = 1; i < dishes.size(); i++) {
      result.append(", " + dishes.get(i).name());
    }
    result.append("] of " + tablet);
    result.append(", cooking time " + getTotalCookingTime() + "min");
    return result.toString();
  }

  public boolean isEmpty() {
    return dishes.isEmpty();
  }

  public int getTotalCookingTime() {
    int cookingTime = 0;
    for (Dish dish : dishes) {
      cookingTime += dish.getDuration();
    }
    return cookingTime;
  }

}
