package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        while(fileReader.ready()) {
            int c1 = fileReader.read();
            if (fileReader.ready()) {
                int c2 = fileReader.read();
                fileWriter.write(c2);
            } else {
                break;
            }

        }
        fileReader.close();
        fileWriter.close();
    }
}
