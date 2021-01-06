package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.HabrCareerStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;
import java.io.IOException;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task28.task2810
 */
public class Aggregator {

  public static void main(String[] args) {
    HtmlView view = new HtmlView();
    Model model = new Model(view, new Provider(new HHStrategy()), new Provider(new HabrCareerStrategy()));
    Controller controller = new Controller(model);

    view.setController(controller);

    view.userCitySelectEmulationMethod();
  }

}
