package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileNameIn = args[0];
        String fileNameOut = args[1];

        //String fileNameIn = "c:\\tmp\\q.txt";
        //String fileNameOut = "c:\\tmp\\out.txt";

        InputStream in = new FileInputStream(fileNameIn);
        OutputStream out = new FileOutputStream(fileNameOut);


        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");


        byte[] buffer = new byte[in.available()];

        in.read(buffer);

        String s = new String(buffer,windows1251);

        buffer = s.getBytes(utf8);

        out.write(buffer);

        in.close();
        out.close();

    }
}
