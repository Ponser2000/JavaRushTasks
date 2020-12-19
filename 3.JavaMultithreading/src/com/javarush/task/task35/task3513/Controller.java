package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

/**
 * @author Sergey Ponomarev on 19.12.2020
 * @project JavaRushTasks/com.javarush.task.task35.task3513
 */
public class Controller extends KeyAdapter {
  private Model model;

  public Tile[][] getGameTiles(){
    return model.getGameTiles();
  }

  public int getScore(){
    return model.score;
  }

}
