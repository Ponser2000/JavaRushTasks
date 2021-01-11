package com.javarush.games.snake;

import com.javarush.engine.cell.*;

/**
 * @author Sergey Ponomarev on 11.01.2021
 * @project JavaRushTasks/com.javarush.games.snake
 */
public class SnakeGame extends Game {

  public static final int WIDTH = 15;
  public static final int HEIGHT = 15;

  @Override
  public void initialize() {
    setScreenSize(WIDTH, HEIGHT);
  }
}
