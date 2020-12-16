package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        FileInputStream inputStream;
        inputStream = new FileInputStream(filename);
        int count=0;

        while(inputStream.available()>0) {
            int c = inputStream.read();
            if ( (c>64 && c<91) || (c>96 && c<123)) {
                count++;
            }
        }

        System.out.println(count);

        inputStream.close();


    }
}
