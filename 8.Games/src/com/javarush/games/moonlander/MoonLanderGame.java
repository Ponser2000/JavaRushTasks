package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

/**
 * @author Sergey Ponomarev on 14.01.2021
 * @project JavaRushTasks/com.javarush.games.moonlander
 */
public class MoonLanderGame extends Game {
  public static final int WIDTH = 64;
  public static final int HEIGHT = 64;

  private Rocket rocket;

  private GameObject landscape;
  private GameObject platform;

  private boolean isUpPressed;
  private boolean isLeftPressed;
  private boolean isRightPressed;
  private boolean isGameStopped;

  private int score;


  @Override
  public void initialize() {
    setScreenSize(WIDTH, HEIGHT);
    createGame();
    showGrid(false);
  }

  private void createGame(){
    isLeftPressed = false;
    isRightPressed = false;
    isUpPressed = false;
    isGameStopped = false;
    score = 1000;
    createGameObjects();
    setTurnTimer(50);
    drawScene();
  }


  private void drawScene(){
    for (int x =0; x < WIDTH; x++)
      for (int y =0; y < WIDTH; y++)
        setCellColor(x, y, Color.BLACK);
    landscape.draw(this);
    rocket.draw(this);
  }

  private void createGameObjects(){
    rocket = new Rocket(WIDTH/2,0);
    landscape = new GameObject(0,25,ShapeMatrix.LANDSCAPE);
    platform = new GameObject(23,MoonLanderGame.HEIGHT - 1, ShapeMatrix.PLATFORM);
  }

  @Override
  public void onTurn(int step) {
    if (score > 0 ) {
      score--;
    }
    rocket.move(isUpPressed,isLeftPressed,isRightPressed);
    check();
    setScore(score);
    drawScene();
  }

  @Override
  public void setCellColor(int x, int y, Color color) {
    if ( 0<= x && x < WIDTH && 0<= y && y< HEIGHT)
      super.setCellColor(x, y, color);
  }

  @Override
  public void onKeyPress(Key key) {
    if (key == Key.UP) {
      isUpPressed = true;
    } else if (key == Key.LEFT) {
      isLeftPressed = true;
      isRightPressed = false;
    } else if (key == Key.RIGHT) {
      isRightPressed = true;
      isLeftPressed = false;
    } else if (key == Key.SPACE && isGameStopped) {
      createGame();
    }
  }

  @Override
  public void onKeyReleased(Key key) {
    if (key == Key.UP) {
      isUpPressed = false;
    } else if (key == Key.RIGHT) {
      isRightPressed = false;
    } else if (key == Key.LEFT) {
      isLeftPressed = false;
    }
  }

  private void check(){
    if (rocket.isCollision(landscape) && !(rocket.isCollision(platform) && rocket.isStopped())) {
      gameOver();
    }
    if (rocket.isStopped() && rocket.isCollision(platform)) {
      win();
    }
  }

  private void win(){
    rocket.land();
    isGameStopped = true;
    showMessageDialog(Color.BLUE, "You win!!!", Color.YELLOW, 24);
    stopTurnTimer();
  }
  private void gameOver(){
    score = 0;
    rocket.crash();
    isGameStopped = true;
    showMessageDialog(Color.GREEN, "You looser!!!", Color.RED, 24);
    stopTurnTimer();
  }

}
