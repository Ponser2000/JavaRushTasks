package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        if(i>=0 && i<=63 && j>=0 && j<=63) { // если i,j попадают в диапазон long
            if ((number & (1l << i)) != (number & (1l << j))) { // если биты числа в заданных позициях не равны
                // поменяй бит на противоположный в позиции i
                number ^= (1l << i); // используем побитовое сложение по модулю 2(XOR) с маской вида 00..1..00
                // поменяй бит на противоположный в позиции j
                number ^= (1l << j); // используем побитовое сложение по модулю 2(XOR) с маской вида 00..1..00
            }
        }
        return number;
    }
}
