package com.javarush.games.racer.road;

/**
 * @author Sergey Ponomarev on 24.03.2021
 * @project JavaRushTasks/com.javarush.games.racer.road
 */
public class Car extends RoadObject{

  public Car(RoadObjectType type, int x, int y){
    super(type,x,y);
    speed = 1;
  }

}
