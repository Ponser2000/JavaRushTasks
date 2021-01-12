package com.javarush.games.snake;

import com.javarush.engine.cell.*;

/**
 * @author Sergey Ponomarev on 11.01.2021
 * @project JavaRushTasks/com.javarush.games.snake
 */
public class SnakeGame extends Game {

  public static final int WIDTH = 15;
  public static final int HEIGHT = 15;

  private Snake snake;
  private int turnDelay;


  @Override
  public void initialize() {
    setScreenSize(WIDTH, HEIGHT);
    createGame();
  }

  private void createGame(){
    snake = new Snake(WIDTH / 2, HEIGHT / 2);
    turnDelay = 300;
    setTurnTimer(turnDelay);
    drawScene();
    // Apple apple = new Apple(7,7);
    // apple.draw(this);
  }

  private void drawScene(){
    for (int x = 0; x < WIDTH; x++) {
      for (int y = 0; y < HEIGHT; y++) {
        setCellColor(x, y, Color.DARKSEAGREEN);
      }
    }
    snake.draw(this);
  }

  @Override
  public void onTurn(int step) {
    snake.move();
    drawScene();

  }
}
