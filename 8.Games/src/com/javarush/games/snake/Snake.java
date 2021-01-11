package com.javarush.games.snake;

import com.javarush.engine.cell.*;
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

  private static final String HEAD_SIGN = "\uD83D\uDC7E";
  private static final String BODY_SIGN = "\u26AB";

  public Snake(int x, int y) {
    this.x = x;
    this.y = y;
    snakeParts.add(new GameObject(x,y));
    snakeParts.add(new GameObject(x+1,y));
    snakeParts.add(new GameObject(x+2,y));
  }

  public void draw(Game game){
      game.setCellValue(snakeParts.get(0).x,snakeParts.get(0).y,HEAD_SIGN);
    for (int i=1; i< snakeParts.size(); i++){
      game.setCellValue(snakeParts.get(i).x,snakeParts.get(i).y,BODY_SIGN);
    }
  }

}
