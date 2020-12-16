package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename=null;
        FileInputStream inputStream=null;

        while (true) {
              filename = reader.readLine();
                inputStream = new FileInputStream(filename);
                if (inputStream.available() < 1000) {
                    inputStream.close();
                    throw new DownloadException();

                }
        }




    }

    public static class DownloadException extends Exception {

    }
}
