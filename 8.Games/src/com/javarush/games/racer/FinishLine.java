package com.javarush.games.racer;

import com.javarush.games.racer.GameObject;
import com.javarush.games.racer.RacerGame;
import com.javarush.games.racer.ShapeMatrix;

/**
 * @author Sergey Ponomarev on 25.03.2021
 * @project JavaRushTasks/com.javarush.games.racer.road
 */
public class FinishLine extends GameObject {

  private boolean isVisible = false;

  public FinishLine() {
    super(RacerGame.ROADSIDE_WIDTH, -1 * ShapeMatrix.FINISH_LINE.length, ShapeMatrix.FINISH_LINE);
  }

  public void show(){
    isVisible = true;
  }

  public void move(int boost){
    if (!isVisible)
      return;

    y += boost;
  }

  public boolean isCrossed(PlayerCar player){

    if (player.y < this.y)
      return true;
    return false;
  }

}
