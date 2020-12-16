package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string)  throws TooShortStringException{
        if (string == null ) {
            throw new TooShortStringException();
        }

        int first = string.indexOf("\t");
        int last = string.lastIndexOf("\t");

        if (first == last) {
            throw new TooShortStringException();
        }

        int second = string.indexOf("\t",first+1);

        return string.substring(first+1,second);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
