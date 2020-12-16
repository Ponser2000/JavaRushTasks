package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Scanner;
import java.io.*;


/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        InputStream inFile = null;

        try {
            fileName = reader.readLine();
            inFile = new FileInputStream(fileName);
            while (inFile.available() > 0) {
                System.out.print((char)inFile.read());
            }
            inFile.close();
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}