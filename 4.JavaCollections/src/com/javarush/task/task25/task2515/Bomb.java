package com.javarush.task.task25.task2515;

/**
 * @author Sergey Ponomarev on 22.12.2020
 * @project JavaRushTasks/com.javarush.task.task25.task2515
 */
public class Bomb extends BaseObject{

  public Bomb(double x, double y) {
    super(x, y, 1);
  }

  public void draw(Canvas canvas) {
    canvas.setPoint(x,y,'B');
  }

  public void move() {
    y++;
  }
}
