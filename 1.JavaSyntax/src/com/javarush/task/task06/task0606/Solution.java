package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int count = Math.abs(n);

        while (count>10) {
            int t = count % 10;
            count = count / 10;

            if (t%2==0)
                even++;
            else
                odd++;
        }

        if (count%2==0)
            even++;
        else
            odd++;

        System.out.println("Even: " + even + " Odd: "+ odd);

    }
}
