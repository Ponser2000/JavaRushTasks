package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.Controller;
import javax.swing.JFrame;

/**
 * @author Sergey Ponomarev on 09.01.2021
 * @project JavaRushTasks/com.javarush.task.task34.task3410.view
 */
public class View extends JFrame {
  private Controller controller;

  public View(Controller controller){
    this.controller = controller;
  }
}
