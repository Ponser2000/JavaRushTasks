package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Sergey Ponomarev on 19.12.2020
 * @project JavaRushTasks/com.javarush.task.task35.task3513
 */
public class Model {

  private static final int FIELD_WIDTH = 4;

  private Tile[][] gameTiles;
  protected int maxTile;
  protected int score = 0;


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
    maxTile = 0;
    addTile();
    addTile();
  }

  private boolean compressTiles(Tile[] tiles){
    AtomicBoolean marker = new AtomicBoolean();
    Arrays.sort(tiles, new Comparator<Tile>() {
      @Override
      public int compare(Tile o1, Tile o2) {
        if(o1.value == 0 & o2.value == 0){
          return 0;
        }
        else if(o1.value == 0 | o2.value == 0){
          int result = o2.value - o1.value;
          if(result < 0) marker.set(true);
          return result;
        }
        else return 0;
      }
    });

    return marker.get();
  }

  private boolean mergeTiles(Tile[] tiles){
    AtomicBoolean marker = new AtomicBoolean();
    compressTiles(tiles);
    Arrays.sort(tiles, new Comparator<Tile>() {
      @Override
      public int compare(Tile o1, Tile o2) {
        if (o1.value == o2.value & o1.value != 0) {
          o1.value *= 2;
          o2.value = 0;
          compressTiles(tiles);
          score += o1.value;
          if (maxTile < o1.value) maxTile = o1.value;
          marker.set(true);
          return 0;
        }
        else return 0;
      }
    });
    return marker.get();
  }

}
