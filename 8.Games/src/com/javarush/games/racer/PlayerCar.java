package com.javarush.games.racer;


import com.javarush.games.racer.road.RoadManager;

/**
 * @author Sergey Ponomarev on 22.03.2021
 * @project JavaRushTasks/com.javarush.games.racer
 */
public class PlayerCar extends GameObject {

  private static int playerCarHeight = ShapeMatrix.PLAYER.length;

  public int speed = 1;

  private Direction direction;


  public PlayerCar() {
    super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void move() {

    if (direction == Direction.RIGHT) x++;

    if (direction == Direction.LEFT) x--;

    if (x > RoadManager.RIGHT_BORDER - width)
      x = RoadManager.RIGHT_BORDER - width;
    if(x < RoadManager.LEFT_BORDER)
      x = RoadManager.LEFT_BORDER;
  }

  public void stop(){
    matrix = ShapeMatrix.PLAYER_DEAD;
  }
}
