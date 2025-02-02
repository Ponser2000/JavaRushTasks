package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * @author Sergey Ponomarev on 29.12.2020
 * @project JavaRushTasks/com.javarush.task.task37.task3702
 */
public class FactoryProducer {

  public enum HumanFactoryType {
    MALE,
    FEMALE
  }

  public static AbstractFactory getFactory(HumanFactoryType humanFactoryType){

    AbstractFactory result = null;

    switch (humanFactoryType) {
      case MALE : {result = new MaleFactory();
      break;
      }
      case FEMALE : {result = new FemaleFactory();
      break;
      }
    }
    return result;
  }
}
