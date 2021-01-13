package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/**
 * @author Sergey Ponomarev on 13.01.2021
 * @project JavaRushTasks/com.javarush.games.game2048
 */
public class Game2048 extends Game {

  private static final int SIDE = 4;

  private int[][] gameField = new int[SIDE][SIDE];


  @Override
  public void initialize() {
    setScreenSize(SIDE, SIDE);
    createGame();
    drawScene();
  }

  private void createGame() {
    createNewNumber();
    createNewNumber();
  }

  private void drawScene(){
    for (int i = 0; i < SIDE; i++)
      for(int j=0; j < SIDE; j++)
        setCellColor(i, j, Color.RED);
  }

  private void createNewNumber(){
    boolean isCreated = false;
    do {
      int x = getRandomNumber(SIDE);
      int y = getRandomNumber(SIDE);
      if (gameField[y][x] == 0) {
        gameField[y][x] = getRandomNumber(10) < 9 ? 2 : 4;
        isCreated = true;
      }
    }
    while (!isCreated);


  }
}
