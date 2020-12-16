package com.javarush.task.task18.task1828;


import java.io.*;
import java.util.*;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(filename));
        List<String> data = readAllLines(reader1);
        reader1.close();
        BufferedWriter writer;



            if (args.length != 0 && args[0].equals("-u")) {
//                System.out.println("Обновляем запись");
                writer = new BufferedWriter(new FileWriter(filename));
                int id = Integer.parseInt(args[1]);

                System.out.println(id);

                String product = args[2];
                if (args[2].length() > 30) {
                    product = args[2].substring(0, 30);
                }
                String price = args[3];
                String count = args[4];
                String out_str = String.format("%-8d%-30s%-8s%-4s", id, product, price, count);

                System.out.println(out_str);

                for (String line : data) {
                    if (id != getID(line)) {
                        writer.write(line);
                        writer.newLine();
                    } else {
                        writer.write(out_str);
                        writer.newLine();
                    }
                }
                writer.close();
            }

            if (args.length != 0 && args[0].equals("-d")) {
                writer = new BufferedWriter(new FileWriter(filename));
//                System.out.println("Удаляем запись");
                int id = Integer.parseInt(args[1]);
                for (String line : data) {
                    if (id != getID(line)) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                writer.close();
            }




    }

    public static int getID (String line){
        String id_s = line.substring(0, 8);
        id_s = id_s.replaceAll(" ", "");
        int id = Integer.parseInt(id_s);
        return id;
    }


    public static List<String> readAllLines(BufferedReader reader) throws IOException {
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            allLines.add(line);
        }
        return allLines;
    }

}
