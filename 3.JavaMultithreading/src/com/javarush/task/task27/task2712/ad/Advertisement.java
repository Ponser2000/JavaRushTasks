package com.javarush.task.task27.task2712.ad;

/**
 * @author Sergey Ponomarev on 18.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.ad
 */
public class Advertisement {

  //видео
  private Object content;

  private String name;

  //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
  private long initialAmount;

  //количество оплаченных показов
  private int hits;

  //продолжительность в секундах
  private int duration;

  private long amountPerOneDisplaying;

  public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
    this.content = content;
    this.name = name;
    this.initialAmount = initialAmount;
    this.hits = hits;
    this.duration = duration;

    if (hits > 0) {
      amountPerOneDisplaying = initialAmount / hits;
    }
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

  public void revalidate() {
    if (hits == 0) {
      throw new UnsupportedOperationException();
    }
    hits--;
  }

  public boolean isActive() {
    return hits > 0;
  }

  public int getHits() {
    return hits;
  }

  public long getAmountPerSecond() {
    // Те самые тысячные доли копейки за секунду
    return amountPerOneDisplaying * 1000 / duration;
  }
}

