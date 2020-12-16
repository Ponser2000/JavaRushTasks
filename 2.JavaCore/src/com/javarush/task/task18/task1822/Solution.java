package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int id = Integer.parseInt(args[0]);

        while (bufferedReader.ready()) {
            String s_orig = bufferedReader.readLine();
            String[] s = s_orig.split(" ");
            if (Integer.parseInt(s[0]) == id) {
                System.out.println(s_orig);
                break;
            }
        }

        bufferedReader.close();
        reader.close();

    }
}
