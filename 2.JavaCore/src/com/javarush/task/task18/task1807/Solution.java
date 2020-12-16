package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = null;
        FileInputStream inputStream;


        try {
            filename = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        inputStream = new FileInputStream(filename);



        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);


            int c=0;
            for(byte b : buffer) {
                if (b == 44) {
                    c++;
                }
            }

            System.out.println(c);



        reader.close();
        inputStream.close();
    }
}
