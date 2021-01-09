package com.javarush.task.task34.task3410.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Sergey Ponomarev on 09.01.2021
 * @project JavaRushTasks/com.javarush.task.task34.task3410.model
 */
public class Wall extends CollisionObject{

  public Wall(int x, int y) {
    super(x, y);
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(new Color(210, 105, 30));

    int xc = getX();
    int yc = getY();
    int height = getHeight();
    int width = getWidth();

    graphics.fillRect(xc - width / 2, yc - height / 2, width, height);
  }

}
