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

  public boolean isAlive = true;

  private List<GameObject> snakeParts = new ArrayList<>();

  private static final String HEAD_SIGN = "\uD83D\uDC7E";
  private static final String BODY_SIGN = "\u26AB";

  private Direction direction = Direction.LEFT;

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Snake(int x, int y) {
    this.x = x;
    this.y = y;
    snakeParts.add(new GameObject(x,y));
    snakeParts.add(new GameObject(x+1,y));
    snakeParts.add(new GameObject(x+2,y));
  }

  public void draw(Game game){
    Color currentCollor = isAlive ? Color.BLACK : Color.RED;
      game.setCellValueEx(snakeParts.get(0).x,snakeParts.get(0).y, Color.NONE, HEAD_SIGN,currentCollor,75);
    for (int i=1; i< snakeParts.size(); i++){
      game.setCellValueEx(snakeParts.get(i).x,snakeParts.get(i).y,Color.NONE,BODY_SIGN,currentCollor,75);
    }
  }

}
