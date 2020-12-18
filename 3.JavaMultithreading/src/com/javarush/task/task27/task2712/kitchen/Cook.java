package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Sergey Ponomarev on 17.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.kitchen
 */

public class Cook  extends Observable implements Observer {
  private final String name;

  public Cook(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public void update(Observable o, Object order) {
    ConsoleHelper.writeMessage("Start cooking - " + order);
    setChanged();
    notifyObservers(order);
  }
}
