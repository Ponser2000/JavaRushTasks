package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sum=0,count=0;
        while (true){
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == -1)
                break;
            sum = sum + n;
            count++;
        }

        if (count>0)
            System.out.println((double) sum / count);
    }
}

