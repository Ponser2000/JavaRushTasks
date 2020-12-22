package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
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
  public Object clone() throws InternalError {
    try {
      AmigoSet<E> amigoSet = (AmigoSet<E>) super.clone();
      amigoSet.map = (HashMap<E, Object>) map.clone();
      return amigoSet;
    } catch (Exception e) {
      throw new InternalError(e);
    }
  }

  @Override
  public Iterator<E> iterator() {
    return map.keySet().iterator();
  }

  @Override
  public int size() {
    return map.size();
  }

  public boolean add(E e) {
    return map.put(e,PRESENT) == null ? true : false;
  }

  @Override
  public boolean remove(Object o) {
    return super.remove(o);
  }

  @Override
  public void clear() {
    map.clear();
  }

  @Override
  public boolean contains(Object o) {
    return super.contains(o);
  }

  @Override
  public boolean isEmpty() {
    return map.isEmpty();
  }


}
