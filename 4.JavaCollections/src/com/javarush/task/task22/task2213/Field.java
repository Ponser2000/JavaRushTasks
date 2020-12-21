package com.javarush.task.task22.task2213;

/**
 * @author Sergey Ponomarev on 21.12.2020
 * @project JavaRushTasks/com.javarush.task.task22.task2213
 */
public class Field {
  //ширина и высота
  private int width;
  private int height;

  //матрица поля: 1 - клетка занята, 0 - свободна
  private int[][] matrix;

  public Field(int width, int height) {
    this.width = width;
    this.height = height;
    matrix = new int[height][width];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int[][] getMatrix() {
    return matrix;
  }
}
