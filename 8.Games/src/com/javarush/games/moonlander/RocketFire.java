package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;
import java.util.List;

/**
 * @author Sergey Ponomarev on 20.03.2021
 * @project JavaRushTasks/com.javarush.games.moonlander
 */
public class RocketFire extends GameObject{

  private List<int[][]> frames;
  private int frameIndex;
  private boolean isVisible;

  public RocketFire( List<int[][]> frameList) {
    super(0, 0, frameList.get(0));
    this.frames = frameList;
    frameIndex = 0;
    isVisible = false;
  }

  private void nextFrame(){
    frameIndex++;
    frameIndex = frameIndex >= frames.size() ? 0 : frameIndex;
    matrix = frames.get(frameIndex);
  }

  @Override
  public void draw(Game game) {
    if (!isVisible) {
      return;
    }
      nextFrame();
      super.draw(game);
  }
}
