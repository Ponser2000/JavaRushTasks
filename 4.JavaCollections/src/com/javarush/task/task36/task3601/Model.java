package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Ponomarev on 29.12.2020
 * @project JavaRushTasks/com.javarush.task.task36.task3601
 */
public class Model {
  private Service service = new Service();

  public List<String> getStringDataList() {
    return service.getData();
  }

}
