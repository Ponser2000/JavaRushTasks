package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(filename1);
        byte[] data1 = new byte[inputStream.available()];
        inputStream.read(data1);
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(filename1);

        inputStream = new FileInputStream(filename2);
        byte[] data2 = new byte[inputStream.available()];
        inputStream.read(data2);
        inputStream.close();

        outputStream.write(data2);

        outputStream.write(data1);
        outputStream.close();

    }
}
