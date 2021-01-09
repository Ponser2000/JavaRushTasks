package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.View;

/**
 * @author Sergey Ponomarev on 09.01.2021
 * @project JavaRushTasks/com.javarush.task.task34.task3410.controller
 */
public class Controller {

  private View view;
  private Model model;

  public Controller() {
    this.view = new View(this);
    this.model = new Model();
    this.view.init();
  }



  public static void main(String[] args) {
    Controller controller = new Controller();
  }
}
