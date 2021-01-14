package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

/**
 * @author Sergey Ponomarev on 14.01.2021
 * @project JavaRushTasks/com.javarush.games.moonlander
 */
public class MoonLanderGame extends Game {
  public static final int WIDTH = 64;
  public static final int HEIGHT = 64;

  @Override
  public void initialize() {
    setScreenSize(WIDTH, HEIGHT);
  }
}
