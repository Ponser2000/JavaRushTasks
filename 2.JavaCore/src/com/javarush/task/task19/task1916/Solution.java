package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filename1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(filename2));

        while(bufferedReader1.ready()) {
            file1.add(bufferedReader1.readLine());
        }
        bufferedReader1.close();

        while(bufferedReader2.ready()) {
            file2.add(bufferedReader2.readLine());
        }
        bufferedReader2.close();

        while(file1.size()>0) {
            String str1 = file1.get(0);
            if(str1.equals(file2.get(0))) {
                lines.add(new LineItem(Type.SAME,str1));
                file1.remove(0);
                file2.remove(0);
            } else {
                boolean flag=false;
                for (String s : file2){
                    if(str1.equals(s)) {
                        flag = true;
                    }
                }
                if (flag) {
                    lines.add(new LineItem(Type.ADDED,file2.get(0)));
                    file2.remove(0);
                } else {
                    lines.add(new LineItem(Type.REMOVED,str1));
                    file1.remove(0);
                }
            }
        }

        while (file2.size()>0){
            lines.add(new LineItem(Type.ADDED,file2.get(0)));
            file2.remove(0);
        }


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
