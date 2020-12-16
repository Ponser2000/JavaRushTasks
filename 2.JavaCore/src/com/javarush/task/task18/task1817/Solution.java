package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        FileInputStream inputStream;
        inputStream = new FileInputStream(filename);
        int count1=0;
        int count2=0;

        while(inputStream.available()>0) {
            int c = inputStream.read();
            count1++;
            if ( c==32) {
                count2++;
            }
        }

        double res = 100.0 * count2 / count1 ;
        System.out.printf("%.2f",res);

        inputStream.close();


    }
}
