package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;
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

  public void setEventListener(EventListener eventListener){
    this.eventListener = eventListener;
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());

    Set<GameObject> gameObjects = view.getGameObjects().getAll();

    for (GameObject gameObject : gameObjects) {
      gameObject.draw(g);
    }
  }

}
