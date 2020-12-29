package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * @author Sergey Ponomarev on 29.12.2020
 * @project JavaRushTasks/com.javarush.task.task36.task3601
 */
public class Controller {
  private Model model = new Model();

  public List<String> onShowDataList() {
    return model.getStringDataList();
  }
}