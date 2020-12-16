package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String[] str = string.trim().split("\\s+");
        String res = "";
        for(int i=0; i < str.length; i++) {
            str[i] = Character.toUpperCase(str[i].charAt(0)) + str[i].substring(1);
            res = res + str[i] + " ";
        }
        res = res.substring(0, res.length() - 1);

        System.out.println(res);
    }
}
