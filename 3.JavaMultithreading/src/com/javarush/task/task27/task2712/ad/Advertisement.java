package com.javarush.task.task27.task2712.ad;

/**
 * @author Sergey Ponomarev on 18.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.ad
 */
public class Advertisement {
  private Object content;
  private String name;
  private long initialAmount;
  private int hits;
  private int duration;

  public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
    this.content = content;
    this.name = name;
    this.initialAmount = initialAmount;
    this.hits = hits;
    this.duration = duration;
  }


}
