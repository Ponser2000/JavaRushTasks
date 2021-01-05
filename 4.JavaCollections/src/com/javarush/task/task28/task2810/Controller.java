package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import java.util.Arrays;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task28.task2810
 */
public class Controller {

  private Provider[] providers;

  public Controller(Provider... providers) {
    if (providers.length != 0) {
      this.providers = providers;
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public String toString() {
    return "Controller{" +
        "providers=" + Arrays.toString(providers) +
        '}';
  }
}
