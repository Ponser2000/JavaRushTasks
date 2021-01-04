package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;
import java.util.logging.SimpleFormatter;

/**
 * @author Sergey Ponomarev on 04.01.2021
 * @project JavaRushTasks/com.javarush.task.task37.task3710.decorators
 */
public class RedShapeDecorator extends ShapeDecorator implements Shape {
  protected Shape decoratedShape;

  public RedShapeDecorator(Shape decoratedShape) {
    super(decoratedShape);
    this.decoratedShape = decoratedShape;
  }

  @Override
  public void draw() {
    setBorderColor(decoratedShape);
    decoratedShape.draw();
  }

  private void setBorderColor(Shape shape) {
    String msg = String.format("Setting the border color for %s to red.",shape.getClass().getSimpleName());
    System.out.println(msg);
  }
}
