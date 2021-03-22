package com.javarush.games.racer;

import com.javarush.engine.cell.*;

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

  @Override
  public void initialize() {
    showGrid(false);
    setScreenSize(WIDTH,HEIGHT);
    createGame();
  }

  private void createGame(){
    roadMarking = new RoadMarking();
    drawScene();
  }
  
  private void drawScene(){
    drawField();
    roadMarking.draw(this);
  }

  private void drawField(){
    for(int i=0; i<ROADSIDE_WIDTH; i++){
      for(int j=0; j< HEIGHT;j++) {
        setCellColor(i,j,Color.GREEN);
        setCellColor(WIDTH - i - 1 ,j,Color.GREEN);
      }
    }

    for(int i=ROADSIDE_WIDTH; i<CENTER_X; i++){
      for(int j=0; j< HEIGHT;j++) {
        setCellColor(i,j,Color.GRAY);
        setCellColor(WIDTH - i - 1 ,j,Color.GRAY);
      }
    }

    for(int j=0; j< HEIGHT;j++) {
      setCellColor(CENTER_X,j,Color.WHITE);
    }
  }

  @Override
  public void setCellColor(int x, int y, Color color) {
    if ( (x>=0 && x < WIDTH) && (y >= 0 && y < HEIGHT)) {
      super.setCellColor(x, y, color);
    }
  }
}
