package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Sergey Ponomarev on 22.12.2020
 * @project JavaRushTasks/com.javarush.task.task37.task3707
 */
public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {

  @Override
  public Iterator iterator() {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }
}
