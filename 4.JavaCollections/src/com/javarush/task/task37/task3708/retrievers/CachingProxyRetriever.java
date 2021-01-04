package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * @author Sergey Ponomarev on 04.01.2021
 * @project JavaRushTasks/com.javarush.task.task37.task3708.retrievers
 */
public class CachingProxyRetriever implements Retriever {
  LRUCache lruCache;
  OriginalRetriever originalRetriever;

  public CachingProxyRetriever(Storage storage) {
    lruCache = new LRUCache(5);
    this.originalRetriever = new OriginalRetriever(storage);
  }

  @Override
  public Object retrieve(long id) {
    Object result = lruCache.find(id);
    if(result == null) {
      result = originalRetriever.retrieve(id);
      lruCache.set(id, result);
    }
    return result;
  }
}