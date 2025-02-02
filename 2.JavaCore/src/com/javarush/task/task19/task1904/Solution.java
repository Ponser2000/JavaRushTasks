package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person;
            String[] s = fileScanner.nextLine().split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(s[5]), Integer.parseInt(s[4])-1 , Integer.parseInt(s[3]));
            Date birthDate = calendar.getTime() ;
            person = new Person(s[1],s[2],s[0],birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
