package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(filename1);
        FileOutputStream outputStream = new FileOutputStream(filename2);

        byte[] buffer1 = new byte[inputStream.available()];
        byte[] buffer2 = new byte[inputStream.available()];
        int count = inputStream.read(buffer1);

        for(byte b : buffer1) {
            buffer2[count-1] = b;
            count--;
        }

        outputStream.write(buffer2);

        inputStream.close();
        outputStream.close();


    }
}
