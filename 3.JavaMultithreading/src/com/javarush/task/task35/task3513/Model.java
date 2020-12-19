package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Ponomarev on 19.12.2020
 * @project JavaRushTasks/com.javarush.task.task35.task3513
 */
public class Model {

  private static final int FIELD_WIDTH = 4;

  private Tile[][] gameTiles;

  public Model() {
    resetGameTiles();
  }

  private List<Tile> getEmptyTiles(){
    List<Tile> tileList = new ArrayList<>();
    for(int i = 0; i < FIELD_WIDTH; i++) {
      for (int j = 0; j < FIELD_WIDTH; j++) {
        if (gameTiles[i][j].value == 0) tileList.add(gameTiles[i][j]);
      }
    }
    return tileList;
  }

  private void addTile(){
    List<Tile> tileList = getEmptyTiles();
    if(tileList.size() > 0){
      int randomNumberList = (int) (Math.random() * tileList.size());
      int randomNumberValue = (int) (Math.random() < 0.9 ? 2 : 4);
      tileList.get(randomNumberList).value = randomNumberValue;
    }
  }

  protected   void resetGameTiles(){
    gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    for(int i = 0; i < FIELD_WIDTH; i++){
      for(int j = 0; j < FIELD_WIDTH; j++){
        gameTiles[i][j] = new Tile();
      }
    }
    // maxTile = 0;
    addTile();
    addTile();
  }

}
