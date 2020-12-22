package com.javarush.task.task25.task2515;

/**
 * @author Sergey Ponomarev on 22.12.2020
 * @project JavaRushTasks/com.javarush.task.task25.task2515
 */
abstract class BaseObject {
  private double x;
  private double y;
  private double radius;
  private boolean isAlive;

  public BaseObject(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.isAlive = true;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public abstract void draw();
  public abstract void move();

  public void die() {
    isAlive = false;
  }

  /**
   * Проверяем - пересекаются ли переданный(o) и наш(this) объекты.
   */
  public boolean isIntersect(BaseObject o) {
    double dx = x - o.x;
    double dy = y - o.y;
    double destination = Math.sqrt(dx * dx + dy * dy);
    double destination2 = Math.max(radius, o.radius);
    return destination <= destination2;
  }

}
