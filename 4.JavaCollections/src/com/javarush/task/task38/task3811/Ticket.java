package com.javarush.task.task38.task3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task38.task3811
 */

@Retention(value= RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Ticket {

  public enum Priority {
    LOW, MEDIUM, HIGH
  }
  String[] s= new String[]{"dfd"};
  Priority priority() default Priority.MEDIUM;
  String[] tags() default {};
  String createdBy() default "Amigo";
}
