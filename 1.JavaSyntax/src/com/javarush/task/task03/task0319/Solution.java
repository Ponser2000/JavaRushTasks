package com.javarush.task.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String s2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        int n1 = Integer.parseInt(s1); //преобразовываем строку в число.
        int n2 = Integer.parseInt(s2); //преобразовываем строку в число.

        System.out.println(name + " получает " + n1 + " через " + n2 + " лет.");

    }
}
