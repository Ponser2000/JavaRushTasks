package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;
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

  private Model model;

  public Controller(Model model) {
    if (model == null) throw new IllegalArgumentException();
    this.model = model;
  }

  public void onCitySelect(String cityName){
    model.selectCity(cityName);
  }
}
