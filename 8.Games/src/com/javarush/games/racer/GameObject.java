package com.javarush.games.racer;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/**
 * @author Sergey Ponomarev on 22.03.2021
 * @project JavaRushTasks/com.javarush.games.racer
 */
public class GameObject {

  public int x;
  public int y;

  public int[][] matrix;

  public int width;
  public int height;

  public GameObject(int x, int y, int[][] matrix) {
    this.x = x;
    this.y = y;
    this.matrix = matrix;
    this.width = matrix[0].length;
    this.height = matrix.length;
  }

  public GameObject(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void draw(Game game) {
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        game.setCellColor(this.x + i, this.y + j, Color.values()[matrix[j][i]]);
      }
    }
  }
}
