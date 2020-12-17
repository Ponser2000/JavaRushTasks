package com.javarush.task.task30.task3010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String number = args[0].toUpperCase();

            int min = 2;
            boolean flag = true;

            if (!number.matches("^[0-9a-zA-Z]+$")) {
                System.out.println("incorrect");
                return;
            }

            char[] ch = number.toCharArray();
            Arrays.sort(ch);
            int c = (int) ch[ch.length-1];
            if (c>47 && c < 58) {
                min = (c - 47) > min ? c - 47 : min;
            } else {
                min = (c - 54) > min ? c - 54 : min;
            }
            System.out.println(min);

        } catch (Exception e) {
        }
    }
}