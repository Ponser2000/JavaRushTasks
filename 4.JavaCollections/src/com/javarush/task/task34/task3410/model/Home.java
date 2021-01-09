package com.javarush.task.task34.task3410.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Sergey Ponomarev on 09.01.2021
 * @project JavaRushTasks/com.javarush.task.task34.task3410.model
 */
public class Home extends GameObject{

  private static final int SIZE = 2;

  public Home(int x, int y) {
    super(x, y, SIZE, SIZE);
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(Color.RED);

    int xc = getX();
    int yc = getY();
    int height = getHeight();
    int width = getWidth();

    graphics.drawOval(xc - width / 2, yc - height / 2, width, height);
  }

}
