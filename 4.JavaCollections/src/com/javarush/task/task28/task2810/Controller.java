package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  public void scan() throws IOException {
    List<Vacancy> totalVacList = new ArrayList<>();

    for (Provider provider : providers) {
      totalVacList.addAll(provider.getJavaVacancies("Краснодар"));
    }

    System.out.println(totalVacList.size());

  }
}
