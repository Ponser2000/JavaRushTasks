package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Sergey Ponomarev on 22.12.2020
 * @project JavaRushTasks/com.javarush.task.task37.task3707
 */
public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {

  private static final Object PRESENT = new Object();
  private transient HashMap<E,Object> map;

  public AmigoSet() {
    map = new HashMap<E,Object>();
  }

  public AmigoSet(Collection<? extends E> collection){
    int size = 16 > (int) Math.ceil(collection.size()/0.75f) ? 16 : (int) Math.ceil(collection.size()/0.75f);
    map = new HashMap<E,Object>(size);
    for (E e : collection) {
      add(e);
    }
  }

  @Override
  public Iterator iterator() {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  public boolean add(E e) {
    return map.put(e,PRESENT) == null ? true : false;
  }
}
