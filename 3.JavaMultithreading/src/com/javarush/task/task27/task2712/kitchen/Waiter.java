package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Sergey Ponomarev on 18.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.kitchen
 */
public class Waiter implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    ConsoleHelper.writeMessage( arg + " was cooked by " + o.toString());
  }
}
