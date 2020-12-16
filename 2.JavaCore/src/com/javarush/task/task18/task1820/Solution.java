package com.javarush.task.task18.task1820;
import java.io.*;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in_file = reader.readLine();
        String out_file = reader.readLine();

        FileInputStream inputStream = new FileInputStream(in_file);
        byte[] data1 = new byte[inputStream.available()];

        String s_n="";
        long n;
        byte b;

        String res="";

        while(inputStream.available()>0) {
            b = (byte) inputStream.read();
            if (b != 32) {
                s_n += (char) b;
            } else {
                if (s_n.contains(".")) {
                    n = Math.round(Double.parseDouble(s_n));
                } else {
                    n = Integer.parseInt(s_n);
                }
                res = res + n + " ";
                s_n ="";
            }
        }


        if (s_n.contains(".")) {
            n = Math.round(Double.parseDouble(s_n));
        } else {
            n = Integer.parseInt(s_n);
        }
        res = res + n;

        FileOutputStream outputStream = new FileOutputStream(out_file);
        outputStream.write(res.getBytes());

        inputStream.close();
        outputStream.close();

    }
}
