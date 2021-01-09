package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Sergey Ponomarev on 09.01.2021
 * @project JavaRushTasks/com.javarush.task.task34.task3410.view
 */
public class Field extends JPanel {
  private View view;
  private EventListener eventListener;

  public Field(View view){
    this.view = view;
  }

  public void paint(Graphics g){

  }

  public void setEventListener(EventListener eventListener){
    this.eventListener = eventListener;
  }
}
