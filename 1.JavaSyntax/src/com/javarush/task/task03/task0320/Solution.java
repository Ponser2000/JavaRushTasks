package com.javarush.task.task03.task0320;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Скромность украшает программиста
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();
        System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");
    }
}
