package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;

/**
 * @author Sergey Ponomarev on 09.01.2021
 * @project JavaRushTasks/com.javarush.task.task34.task3410.controller
 */
public interface EventListener {
  public void move(Direction direction);
  public void restart();
  public void startNextLevel();
  public void levelCompleted(int level);

}
