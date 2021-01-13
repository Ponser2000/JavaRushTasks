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
        setCellColoredNumber(i, j, gameField[j][i]);
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

  private Color getColorByValue(int value){
    return switch (value) {
      case 0 -> Color.WHITE;
      case 2 -> Color.PLUM;
      case 4 -> Color.SLATEBLUE;
      case 8 -> Color.DODGERBLUE;
      case 16 -> Color.DARKTURQUOISE;
      case 32 -> Color.MEDIUMSEAGREEN;
      case 64 -> Color.LIMEGREEN;
      case 128 -> Color.DARKORANGE;
      case 256 -> Color.SALMON;
      case 512 -> Color.ORANGERED;
      case 1024 -> Color.DEEPPINK;
      case 2048 -> Color.MEDIUMVIOLETRED;
      default -> Color.NONE;
    };
  }

  private void setCellColoredNumber(int x, int y, int value){
    Color color = getColorByValue(value);
    String msg = value > 0 ? String.valueOf(value) : "";
    setCellValueEx(x, y, color, msg);

  }
}
