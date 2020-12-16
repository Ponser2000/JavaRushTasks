package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename="";
        try {
            filename = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader =new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String str;
        ArrayList<String> wordsList = new ArrayList<String>();

        while( ( str = reader.readLine()) != null) {
            for(String word : str.split(" ")) {
                if (!word.isEmpty()) {
                    wordsList.add(word);
                }
            }
        }





        for(int i=0; i< wordsList.size(); i++) {

            if(wordsList.get(i)==null) {continue;}

            for(int j=i+1; j<wordsList.size(); j++) {
                if(wordsList.get(j)==null) {continue;}

                StringBuilder reverse = new StringBuilder(wordsList.get(j)).reverse();

                if (wordsList.get(i).equals(reverse.toString())) {

                    Pair p = new Pair();
                    p.first = wordsList.get(i);
                    p.second = wordsList.get(j);

//                    if (result.contains(p) || result.contains(p1))
//                        continue;

                    result.add(p);
                    wordsList.set(i,null);
                    wordsList.set(j,null);
                    break;
                }
            }
        }

        for(Pair p : result) {
            System.out.println(p.toString());
        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair(){

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
