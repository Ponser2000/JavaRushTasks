package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[1];
        String fileOutputName = args[2];

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);

        byte[] date = new byte[inputStream.available()];
        inputStream.read(date);

        if (args[0].equals("-d")) {
            outputStream.write(crypt(date));
        } else if (args[0].equals("-e")) {
            outputStream.write(crypt(date));
        }

        inputStream.close();
        outputStream.close();

    }

    public static byte[] crypt(byte[] data) {
        byte[] date1 = new byte[data.length];
        for(int i=0; i<data.length; i++) {
            date1[data.length-1-i]=data[i];
        }
        return date1;
    }

}
