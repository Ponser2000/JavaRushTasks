package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

/**
 * @author Sergey Ponomarev on 22.03.2021
 * @project JavaRushTasks/com.javarush.games.racer
 */
public class RacerGame extends Game {

  public static final int WIDTH = 64;
  public static final int HEIGHT = 64;

  public static final int CENTER_X = WIDTH / 2;
  public static final int ROADSIDE_WIDTH = 14;

  private RoadMarking roadMarking;

  private PlayerCar player;

  private RoadManager roadManager;

  private boolean isGameStopped;

  private FinishLine finishLine;

  private static final int RACE_GOAL_CARS_COUNT = 40;

  private ProgressBar progressBar;

  @Override
  public void initialize() {
    showGrid(false);
    setScreenSize(WIDTH, HEIGHT);
    createGame();
  }

  private void createGame() {
    isGameStopped = false;
    roadMarking = new RoadMarking();
    player = new PlayerCar();
    roadManager = new RoadManager();
    finishLine = new FinishLine();
    progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
    drawScene();
    setTurnTimer(40);
  }

  private void drawScene() {
    drawField();
    progressBar.draw(this);
    finishLine.draw(this);
    roadManager.draw(this);
    roadMarking.draw(this);
    player.draw(this);
  }

  private void drawField() {
    for (int i = 0; i < ROADSIDE_WIDTH; i++) {
      for (int j = 0; j < HEIGHT; j++) {
        setCellColor(i, j, Color.GREEN);
        setCellColor(WIDTH - i - 1, j, Color.GREEN);
      }
    }

    for (int i = ROADSIDE_WIDTH; i < CENTER_X; i++) {
      for (int j = 0; j < HEIGHT; j++) {
        setCellColor(i, j, Color.GRAY);
        setCellColor(WIDTH - i - 1, j, Color.GRAY);
      }
    }

    for (int j = 0; j < HEIGHT; j++) {
      setCellColor(CENTER_X, j, Color.WHITE);
    }
  }

  @Override
  public void setCellColor(int x, int y, Color color) {
    if ((x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT)) {
      super.setCellColor(x, y, color);
    }
  }

  private void moveAll() {
    finishLine.move(player.speed);
    roadMarking.move(player.speed);
    player.move();
    roadManager.move(player.speed);
    progressBar.move(roadManager.getPassedCarsCount());
  }

  @Override
  public void onTurn(int step) {
    if (roadManager.checkCrush(player)){
      gameOver();
      drawScene();
      return;
    }

    roadManager.generateNewRoadObjects(this);
    if (roadManager.getPassedCarsCount()>=RACE_GOAL_CARS_COUNT )
      finishLine.show();
    if (finishLine.isCrossed(player)) {
      win();
      drawScene();
      return;
    }
    moveAll();
    drawScene();
  }

  @Override
  public void onKeyPress(Key key) {
    if (key == Key.LEFT)
      player.setDirection(Direction.LEFT);
    if (key == Key.RIGHT)
      player.setDirection(Direction.RIGHT);
    if (key == Key.SPACE && isGameStopped) {
      createGame();
    }
    if (key == Key.UP) {
      player.speed = 2;
    }
  }

  @Override
  public void onKeyReleased(Key key) {
    if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT)
      player.setDirection(Direction.NONE);
    if (key == Key.LEFT && player.getDirection() == Direction.LEFT)
      player.setDirection(Direction.NONE);
    if (key == Key.UP) {
      player.speed = 1;
    }
  }

  private void gameOver(){
    isGameStopped = true;
    showMessageDialog(Color.GREEN, "You looser!!!", Color.RED, 24);
    stopTurnTimer();
    player.stop();
  }

  private void win(){
    isGameStopped = true;
    showMessageDialog(Color.BLUE, "You WIN!!!!", Color.YELLOW, 24);
    stopTurnTimer();
  }
}
