package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

/**
 * @author Sergey Ponomarev on 17.12.2020
 * @project JavaRushTasks/com.javarush.task.task30.task3004
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {

  private int x;

  public BinaryRepresentationTask(int i) {
    this.x = i;
  }

  @Override
  protected String compute() {
    if (x == 0)
      return "";
    int a = x % 2;
    int b = x / 2;
    if (b > 0){
      BinaryRepresentationTask task = new BinaryRepresentationTask(b);
      task.fork();
      return task.join()+a;
    }
    return String.valueOf(a);
  }
}
