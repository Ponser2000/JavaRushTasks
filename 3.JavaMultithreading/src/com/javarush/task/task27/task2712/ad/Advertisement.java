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
  private long amountPerOneDisplaying;

  public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
    this.content = content;
    this.name = name;
    this.initialAmount = initialAmount;
    this.hits = hits;
    this.duration = duration;
    this.amountPerOneDisplaying = hits == 0 ? 0 : initialAmount / hits;
  }

  public String getName() {
    return name;
  }

  public int getDuration() {
    return duration;
  }

  public long getAmountPerOneDisplaying() {
    return amountPerOneDisplaying;
  }

  public void revalidate(){
    if(this.hits <= 0) throw new UnsupportedOperationException();
    if(this.hits > 0) this.hits--;
  }

  public int getHits()
  {
    return hits;
  }

  public long getAmountPerSecond()
  {
    // Те самые тысячные доли копейки за секунду
    return amountPerOneDisplaying*1000/duration;
  }

}
