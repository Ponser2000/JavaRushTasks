package com.javarush.task.task35.task3513;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @author Sergey Ponomarev on 19.12.2020
 * @project JavaRushTasks/com.javarush.task.task35.task3513
 */
public class Main {
  
  public static void main(String[] args) {
    Model model = new Model();
    Controller controller = new Controller(model);
    JFrame jFrame = new JFrame();

    jFrame.setTitle("2048");
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setSize(450, 500);
    jFrame.setResizable(false);

    jFrame.add(controller.getView());


    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

}
