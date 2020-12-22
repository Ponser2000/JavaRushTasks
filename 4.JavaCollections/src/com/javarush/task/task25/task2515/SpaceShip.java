package com.javarush.task.task25.task2515;

/**
 * @author Sergey Ponomarev on 22.12.2020
 * @project JavaRushTasks/com.javarush.task.task25.task2515
 */
public class SpaceShip extends BaseObject{
  private double dx = 0;

  public SpaceShip(double x, double y) {
    super(x, y, 3);
  }

  public void draw() {

  }

  @Override
  public void move() {

  }

  public void moveLeft() { dx = -1;}
  public void moveRight() {dx = 1;}
}
