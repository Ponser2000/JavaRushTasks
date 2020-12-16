package com.javarush.task.task04.task0423;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Фейс-контроль
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();

        String sAge = bufferedReader.readLine();
        int nAge = Integer.parseInt(sAge);

        if (nAge > 20)
            System.out.println("И 18-ти достаточно");
    }
}
