package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        String[] s = result.split(" ");


        if ( s[1].equals("+")) {
            int res = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
            result = result+res;
        } else if ( s[1].equals("-")) {
            int res = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
            result = result+res;
        } else if ( s[1].equals("*")) {
            int res = Integer.parseInt(s[0]) * Integer.parseInt(s[2]);
            result = result+res;
        }

        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

