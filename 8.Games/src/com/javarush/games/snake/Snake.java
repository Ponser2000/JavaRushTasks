package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Ponomarev on 11.01.2021
 * @project JavaRushTasks/com.javarush.games.snake
 */
public class Snake {
  private int x;
  private int y;

  private List<GameObject> snakeParts = new ArrayList<>();

  public Snake(int x, int y) {
    this.x = x;
    this.y = y;
    snakeParts.add(new GameObject(x,y));
    snakeParts.add(new GameObject(x+1,y));
    snakeParts.add(new GameObject(x+2,y));
  }


}
