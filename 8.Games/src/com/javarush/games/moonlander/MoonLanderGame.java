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

  private boolean isUpPressed;
  private boolean isLeftPressed;
  private boolean isRightPressed;


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
  }

  @Override
  public void onTurn(int step) {
    rocket.move();
    drawScene();
  }

  @Override
  public void setCellColor(int x, int y, Color color) {
    if ( 0<= x && x < WIDTH && 0<= y && y< HEIGHT)
      super.setCellColor(x, y, color);
  }
}
