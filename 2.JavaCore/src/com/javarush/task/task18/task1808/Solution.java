package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(filename1);
        FileOutputStream outputStream1 = new FileOutputStream(filename2);
        FileOutputStream outputStream2 = new FileOutputStream(filename3);

        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);

        int len = count % 2 == 0 ? count / 2 : 1 + count / 2;

        outputStream1.write(buffer, 0, len);
        outputStream2.write(buffer, len , count - len );

        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
