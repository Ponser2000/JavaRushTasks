package com.javarush.games.snake;

import com.javarush.engine.cell.*;

/**
 * @author Sergey Ponomarev on 11.01.2021
 * @project JavaRushTasks/com.javarush.games.snake
 */
public class SnakeGame extends Game {

  public static final int WIDTH = 15;
  public static final int HEIGHT = 15;
  private static final int GOAL = 28;

  private Snake snake;
  private int turnDelay;
  private Apple apple;
  private boolean isGameStopped;


  @Override
  public void initialize() {
    setScreenSize(WIDTH, HEIGHT);
    createGame();
  }

  private void createGame(){
    snake = new Snake(WIDTH / 2, HEIGHT / 2);
    turnDelay = 300;
    setTurnTimer(turnDelay);
    createNewApple();
    isGameStopped = false;
    drawScene();
  }

  private void drawScene(){
    for (int x = 0; x < WIDTH; x++) {
      for (int y = 0; y < HEIGHT; y++) {
        setCellValueEx(x, y, Color.DARKSEAGREEN,"");
      }
    }
    snake.draw(this);
    apple.draw(this);
  }

  @Override
  public void onTurn(int step) {
    snake.move(apple);
    if (!apple.isAlive) createNewApple();
    if (!snake.isAlive) gameOver();
    if (snake.getLength()>GOAL) win();
    drawScene();

  }

  @Override
  public void onKeyPress(Key key) {
    switch (key) {
      case LEFT:
        snake.setDirection(Direction.LEFT);
        break;
      case RIGHT:
        snake.setDirection(Direction.RIGHT);
        break;
      case UP:
        snake.setDirection(Direction.UP);
        break;
      case DOWN:
        snake.setDirection(Direction.DOWN);
        break;
      case SPACE:
        if (isGameStopped) createGame();
        break;
    }
  }

  private void createNewApple(){
    do {
      int x = getRandomNumber(WIDTH);
      int y = getRandomNumber(HEIGHT);
      apple = new Apple(x, y);
    } while (snake.checkCollision(apple));
  }

  private void gameOver(){
    stopTurnTimer();
    isGameStopped = true;
    showMessageDialog(Color.NONE, "GAME OVER", Color.RED, 50);
  }

  private void win(){
    stopTurnTimer();
    isGameStopped = true;
    showMessageDialog(Color.NONE, "YOU WIN", Color.RED, 50);
  }
}
