package com.javarush.task.task27.task2712.ad;

/**
 * @author Sergey Ponomarev on 18.12.2020
 * @project JavaRushTasks/com.javarush.task.task27.task2712.ad
 */
public class AdvertisementStorage {
  private static AdvertisementStorage instance = new AdvertisementStorage();

  public static AdvertisementStorage getInstance(){
    return instance;
  }

  private AdvertisementStorage() {
  }

}
