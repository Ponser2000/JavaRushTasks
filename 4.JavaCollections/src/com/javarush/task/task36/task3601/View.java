package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * @author Sergey Ponomarev on 29.12.2020
 * @project JavaRushTasks/com.javarush.task.task36.task3601
 */
public class View {
  private Controller controller = new Controller();

  public void fireShowDataEvent() {
    System.out.println(controller.onShowDataList());
  }
}
