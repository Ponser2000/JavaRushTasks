package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Sergey Ponomarev on 03.01.2021
 * @project JavaRushTasks/com.javarush.task.task33.task3310.strategy
 */
public class HashMapStorageStrategy implements StorageStrategy{
  private HashMap<Long, String> data ;

  public HashMapStorageStrategy() {
    this.data = new HashMap<>();
  }

  @Override
  public boolean containsKey(Long key) {
    return data.containsKey(key);
  }

  @Override
  public boolean containsValue(String value) {
    return data.containsValue(value);
  }

  @Override
  public void put(Long key, String value) {
    data.put(key,value);
  }

  @Override
  public Long getKey(String value) {
    for (Entry<Long, String> longStringEntry : data.entrySet()) {
      if (longStringEntry.getValue().equals(value)) {
        return longStringEntry.getKey();
      }
    }
    return null;
  }

  @Override
  public String getValue(Long key) {
    return data.get(key);
  }
}
