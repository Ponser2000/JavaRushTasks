package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        List<String> file_words = new ArrayList<>();

        String str;
        while( (str = reader.readLine()) != null) {
            file_words.addAll(Arrays.asList(str.split(" ")));
        }

        String[] words = file_words.toArray(new String[0]);





        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) {
            return new StringBuilder();
        }

        StringBuilder res = new StringBuilder(words[0]);


        int count=0;


        while(true) {
            StringBuilder tmp_word = new StringBuilder();
            for(String s : words) {
                if (res.toString().toLowerCase().contains(s.toLowerCase())) {
                    continue;
                } else if (tmp_word.length()==0) {
                    tmp_word.append(s);
                } else {
                    tmp_word.append(" "+s);
                }
            }

            //System.out.println(tmp_word.toString()+"---");

            String[] tmp_words = tmp_word.toString().split(" ");

            if (tmp_word.length() == 0 || count > 8) {
                break;
            }


            for(int i=0; i < tmp_words.length; i++){
                if (res.toString().toLowerCase().charAt(0) == tmp_words[i].toLowerCase().charAt(tmp_words[i].length()-1)) {
                    StringBuilder tmp = new StringBuilder(tmp_words[i]);
                    res = tmp.append(" "+ res);
                } else if (res.toString().toLowerCase().charAt(res.length()-1) == tmp_words[i].toLowerCase().charAt(0)) {
                    StringBuilder tmp = new StringBuilder(tmp_words[i]);
                    res = res.append(" "+ tmp);
                }

            }

            count++;
        }

        return res;

    }
}
