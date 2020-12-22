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

  public void draw(Canvas canvas){}

  @Override
  public void move() {
    x += dx;
    checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
  }

  public void moveLeft() { dx = -1;}
  public void moveRight() {dx = 1;}

  public void fire(){
    Space.game.getRockets().add(new Rocket(x - 2, y));
    Space.game.getRockets().add(new Rocket(x + 2, y));
  }
}
