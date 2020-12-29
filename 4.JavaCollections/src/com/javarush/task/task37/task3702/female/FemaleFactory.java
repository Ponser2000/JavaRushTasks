package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

/**
 * @author Sergey Ponomarev on 29.12.2020
 * @project JavaRushTasks/com.javarush.task.task37.task3702.female
 */
public class FemaleFactory implements AbstractFactory {
  public Human getPerson(int age){
    Human result;
    if (age > TeenGirl.MAX_AGE) {
      result = new Woman();
    } else if (age > KidGirl.MAX_AGE) {
      result = new TeenGirl();
    } else {
      result = new KidGirl();
    }
    return  result;
  }

}
