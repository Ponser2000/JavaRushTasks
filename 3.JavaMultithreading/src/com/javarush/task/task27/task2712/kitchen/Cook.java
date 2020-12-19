package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Sergey Ponomarev on 17.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.kitchen
 */

public class Cook extends Observable implements Observer {

  private final String name;
  boolean busy;
  private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

  public Cook(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public void update(Observable observable, Object arg) {
    Order order = (Order) arg;
    ConsoleHelper.writeMessage("Start cooking - " + order);
    StatisticManager.getInstance().register(new CookedOrderEventDataRow(
        observable.toString(),
        this.name,
        order.getTotalCookingTime()*60,
        order.getDishes()));
    setChanged();
    notifyObservers(order);

  }

  public void startCookingOrder(Order order) {
    this.busy = true;
    ConsoleHelper.writeMessage(
        "Start cooking - " + order.toString() + ", cooking time " + order.getTotalCookingTime()
            + "min");
    try {
      Thread.currentThread().sleep(order.getTotalCookingTime() * 10);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    EventDataRow cookEvent = new CookedOrderEventDataRow(order.tablet.toString(), this.name,
        order.getTotalCookingTime() * 60, order.getDishes());
    StatisticManager sMannager = StatisticManager.getInstance();
    sMannager.register(cookEvent);
    setChanged();
    notifyObservers(order);
    this.busy = false;
  }

}
