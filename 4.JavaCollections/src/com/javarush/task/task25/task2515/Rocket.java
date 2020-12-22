package com.javarush.task.task25.task2515;

/**
 * @author Sergey Ponomarev on 22.12.2020
 * @project JavaRushTasks/com.javarush.task.task25.task2515
 */
public class Rocket extends BaseObject {

  public Rocket(double x, double y) {
    super(x, y, 1);
  }

  @Override
  public void draw(Canvas canvas) {
    canvas.setPoint(x, y, 'R');
  }

  public void move() {
    y--;
  }
}
