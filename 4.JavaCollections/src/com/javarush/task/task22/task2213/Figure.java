package com.javarush.task.task22.task2213;

/**
 * @author Sergey Ponomarev on 21.12.2020
 * @project JavaRushTasks/com.javarush.task.task22.task2213
 */
public class Figure {
  // Матрица которая определяет форму фигурки: 1 - клетка не пустая, 0 - пустая
  private int[][] matrix;
  // Координаты
  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int[][] getMatrix() {
    return matrix;
  }

  public Figure(int x, int y, int[][] matrix) {
    this.x = x;
    this.y = y;
    this.matrix = matrix;
  }
}
