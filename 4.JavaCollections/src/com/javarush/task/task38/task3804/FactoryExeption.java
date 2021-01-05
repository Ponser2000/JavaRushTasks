package com.javarush.task.task38.task3804;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task38.task3804
 */
public class FactoryExeption {


  static Throwable getException(Enum enumm) {
    if (enumm == null)
      return new IllegalArgumentException();
    String message = enumm.name().toLowerCase().replaceAll("[_]", " ");
    String first = message.substring(0, 1).toUpperCase();
    message = first + message.substring(1);

    switch (enumm.getClass().getSimpleName()) {
      case "ApplicationExceptionMessage":
        return new Exception(message);
      case "DatabaseExceptionMessage":
        return new RuntimeException(message);
      case "UserExceptionMessage":
        return new Error(message);
      default:
        return new IllegalArgumentException();
    }
  }
}