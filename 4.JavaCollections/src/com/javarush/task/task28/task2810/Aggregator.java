package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import java.io.IOException;

/**
 * @author Sergey Ponomarev on 05.01.2021
 * @project JavaRushTasks/com.javarush.task.task28.task2810
 */
public class Aggregator {

  public static void main(String[] args) throws IOException {
    Provider provider = new Provider(null);
    Controller controller = new Controller(provider);
    controller.scan();
  }

}
