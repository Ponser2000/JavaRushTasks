package com.javarush.task.task04.task0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
18+
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();

        String sAge = bufferedReader.readLine();
        int nAge = Integer.parseInt(sAge);

        if (nAge < 18)
            System.out.println("Подрасти еще");
    }
}
