package com.javarush.task.task28.task2810.model;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task28.task2810.model
 */
public class Provider {
  private Strategy strategy;

  public Provider(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
