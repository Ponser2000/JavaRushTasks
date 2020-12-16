package com.javarush.task.task04.task0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        int n3 = Integer.parseInt(bufferedReader.readLine());

        if ( n1 > 0 && n2 > 0 && n3 > 0) {
            System.out.println(3);
        } else if ( (n1 > 0 && n2 > 0 && n3 <= 0) || (n1 > 0 && n2 <= 0 && n3 > 0) || (n1 <= 0 && n2 > 0 && n3 > 0)) {
            System.out.println(2);
        } else if ( n1 <= 0 && n2 <= 0 && n3 <= 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
