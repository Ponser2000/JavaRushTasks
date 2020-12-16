package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/


public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }
    public static int getRectangleCount(byte[][] a) {
        byte[][] catched = new byte[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                catched[i][j] = 0;
            }
        }
//                {
//            {0, 0, 0, 0},
//            {0, 0, 0, 0},
//            {0, 0, 0, 0},
//            {0, 0, 0, 0}
//        };    //матрица "погашенных" прямоугольников
        int rectangleCount = 0;    //счётчик прямоугольников
        boolean isCatched = false;    //прямоугольник пойман
        int beginX = 0;
        int finishX = 0;    //координаты пойманного прямоугольник по оси X
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1 && catched[i][j] != 1) {    //если клетка не пустая и ещё не погашена
//                    catched[i][j] = 1;    //гасим клетку
                    if (!isCatched) {    //если при этом мы не в режиме пойманного прямоугольника
                        isCatched = true;    //переключаемся в режим
                        beginX = j;    //помечаем клетку начала следующей итерации
                    }
                }
                if ((a[i][j] == 0 && isCatched) || (j == a[i].length - 1 && isCatched)) {    //если заступили за границу прямоугольника (включён режим поиска)
                    if (a[i][j] == 0 && isCatched) finishX = j;    //помечаем клетку окончания следующей итерации
                    else finishX = j + 1;
                    for (int l = i; l < a.length; l++) {    //вычисляем прямоугольник
                        for (int k = beginX; k < finishX; k++) {    //бежим по линии прямоугольника
                            if (a[l][k] == 1) catched[l][k] = 1;    //если это ещё прямоугольник
                        }
                        if (l == a.length - 1 || a[l + 1][beginX] == 0) {
//                            System.out.printf("catched: %d, %d%n", l, beginX);    //треугольник пойман
                            rectangleCount++;
                            isCatched = false;
                            break;
                        }
                    }
                }
            }
        }
//        for (byte[] aCatched : catched) {    //вывод матрицы погашеных клеток
//            for (byte anACatched : aCatched) {
//                System.out.print(anACatched);
//            }
//            System.out.println();
//        }
        return rectangleCount;
    }
}