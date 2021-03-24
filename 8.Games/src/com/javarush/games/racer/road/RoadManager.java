package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.RacerGame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sergey Ponomarev on 23.03.2021
 * @project JavaRushTasks/com.javarush.games.racer.road
 */
public class RoadManager {

  public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
  public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;

  private static final int FIRST_LANE_POSITION = 16;
  private static final int FOURTH_LANE_POSITION = 44;

  private List<RoadObject> items = new ArrayList<>();


  private RoadObject createRoadObject(RoadObjectType type, int x, int y){
    if (type == RoadObjectType.THORN )
      return new Thorn(x,y);
    else
      return null;
  }

  private void addRoadObject(RoadObjectType type, Game game){
    int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
    int y = -1 * RoadObject.getHeight(type);
    RoadObject result = createRoadObject(type, x, y);
    if (result != null)
      items.add(result);
  }

  public void draw(Game game){
    for (RoadObject item : items) {
      item.draw(game);
    }
  }

  public void move(int boost){
    for (RoadObject item : items) {
      item.move(boost + item.speed);
    }
    deletePassedItems();
  }

  private boolean isThornExists(){
    for (RoadObject item : items) {
      if (item.type == RoadObjectType.THORN)
        return true;
    }
    return false;
  }

  private void generateThorn(Game game){
    int res = game.getRandomNumber(100);
    if (res < 10 && !isThornExists()) {
      addRoadObject(RoadObjectType.THORN, game);
    }
  }

  public void generateNewRoadObjects(Game game){
    generateThorn(game);
  }

  private void deletePassedItems(){
    items.removeIf(item -> item.y >= RacerGame.HEIGHT);
  }
}
