package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * @author Sergey Ponomarev on 03.01.2021
 * @project JavaRushTasks/com.javarush.task.task33.task3310
 */
public class Shortener {
  private Long lastId = 0L;
  private StorageStrategy storageStrategy;

  public Shortener(StorageStrategy storageStrategy) {
    this.storageStrategy = storageStrategy;
  }

  public synchronized Long getId(String string){
    if (storageStrategy.containsValue(string)) {
      return storageStrategy.getKey(string);
    }
    lastId++;
    storageStrategy.put(lastId,string);
    return lastId;
  }

  public synchronized String getString(Long id) {
    return storageStrategy.getValue(id);
  }

}
