package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int max=0;
        while (fileInputStream.available()>0) {
            int b = fileInputStream.read();
            if (b > max) { max=b;}
        }
        fileInputStream.close();
        System.out.println(max);
    }
}
