package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

/**
 * @author Sergey Ponomarev on 29.12.2020
 * @project JavaRushTasks/com.javarush.task.task37.task3702.male
 */
public class MaleFactory {
  public Human getPerson(int age){
    Human result;
    if (age > TeenBoy.MAX_AGE) {
      result = new Man();
    } else if (age > KidBoy.MAX_AGE) {
      result = new TeenBoy();
    } else {
      result = new KidBoy();
    }
    return  result;
  }

}
