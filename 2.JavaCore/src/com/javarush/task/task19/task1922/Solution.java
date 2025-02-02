package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();

        reader.close();

        reader = new BufferedReader(new FileReader(filename));

        int count;
        while (reader.ready()) {
            String str = reader.readLine();
            count = 0;

            String[] str1 = str.split(" ");

            for(String s1 : str1) {
                for (String s : words) {
                    if (s1.equals(s)) {
                    count ++;
                    }
                }
            }

            if (count == 2) {
                System.out.println(str);
            }

        }

        reader.close();

    }
}
