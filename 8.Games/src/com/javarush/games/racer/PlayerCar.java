package com.javarush.games.racer;


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

    if (direction == Direction.RIGHT)
      x++;
    if (direction == Direction.LEFT)
      x--;

  }
}
