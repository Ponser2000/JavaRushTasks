package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String filename = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            int size = s.length;
            String name="";
            for(int i=0; i<size-3; i++) {
                name = name + s[i] + " ";
            }
            name = name.trim();

            String str_date = s[size-3] + " " + s[size-2] + " " +s[size-1];
            DateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            Date date = formatter.parse(str_date);

            PEOPLE.add(new Person(name,date));

        }

        reader.close();
    }
}