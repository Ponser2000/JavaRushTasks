package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

/**
 * @author Sergey Ponomarev on 03.01.2021
 * @project JavaRushTasks/com.javarush.task.task33.task3310.strategy
 */
public class OurHashBiMapStorageStrategy implements StorageStrategy{

  private HashMap<Long, String> k2v;
  private HashMap<String, Long> v2k;

  public OurHashBiMapStorageStrategy() {
    k2v = new HashMap<>();
    v2k = new HashMap<>();
  }

  @Override
  public boolean containsKey(Long key) {
    return k2v.containsKey(key);
  }

  @Override
  public boolean containsValue(String value) {
    return v2k.containsKey(value);
  }

  @Override
  public void put(Long key, String value) {
    k2v.put(key, value);
    v2k.put(value, key);
  }

  @Override
  public Long getKey(String value) {
    return v2k.get(value);
  }

  @Override
  public String getValue(Long key) {
    return k2v.get(key);
  }

}
