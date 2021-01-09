package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * @author Sergey Ponomarev on 09.01.2021
 * @project JavaRushTasks/com.javarush.task.task34.task3410.model
 */
public class Model {
  public static final int FIELD_CELL_SIZE = 20;
  private EventListener eventListener;
  private GameObjects gameObjects;
  private int currentLevel = 1;
  private LevelLoader levelLoader;

  public Model() {
    try {
      levelLoader = new LevelLoader(Paths.get(getClass().getResource("../res/levels.txt").toURI()));
    } catch (URISyntaxException e) {
    }
  }

  public void setEventListener(EventListener eventListener){
    this.eventListener = eventListener;
  }
  

  public void restart() {
    restartLevel(currentLevel);
  }

  public void startNextLevel() {
    currentLevel++;
    restartLevel(currentLevel);
  }

  public void restartLevel(int level) {
    gameObjects = levelLoader.getLevel(level);
  }

  public GameObjects getGameObjects() {
    return gameObjects;
  }
}
