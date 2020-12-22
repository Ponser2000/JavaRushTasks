package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Ponomarev on 22.12.2020
 * @project JavaRushTasks/com.javarush.task.task25.task2515
 */
public class Space {
  private int width;
  private int height;
  private List<Ufo> ufos = new ArrayList<>();
  private List<Rocket> rockets = new ArrayList<>();
  private List<Bomb> bombs = new ArrayList<>();

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  private SpaceShip ship;

  public SpaceShip getShip() {
    return ship;
  }

  public void setShip(SpaceShip ship) {
    this.ship = ship;
  }

  public List<Ufo> getUfos() {
    return ufos;
  }

  public List<Rocket> getRockets() {
    return rockets;
  }

  public List<Bomb> getBombs() {
    return bombs;
  }

  public Space(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public static void main(String[] args) {

  }
}
