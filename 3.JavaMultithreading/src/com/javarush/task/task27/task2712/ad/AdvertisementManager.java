package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

/**
 * @author Sergey Ponomarev on 18.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.ad
 */
public class AdvertisementManager {
  private final AdvertisementStorage storage;
  private int timeSeconds;

  public AdvertisementManager(int timeSeconds) {
    storage = AdvertisementStorage.getInstance();
    this.timeSeconds = timeSeconds;
  }

  public void processVideos(){
    ConsoleHelper.writeMessage("calling processVideos method");
  }
}
