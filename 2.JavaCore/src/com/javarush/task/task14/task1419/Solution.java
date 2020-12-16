package com.javarush.task.task14.task1419;



import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;


/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    public static String doSmth(String s) {
        return s.substring(0, 5);
    }

    private static void initExceptions() {   //the first exception



        try {
            float i = 1 / 0;

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            exceptions.get(exceptions.size());

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            doSmth(s);

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream in = new FileInputStream("X:\\sdfs.txt");

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String n = "";
            int number = Integer.parseInt(n);

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String n = "dfsfsdf";
            char newS = n.charAt(-1);

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new IOException();
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String[] arrS = new String[-4];

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object o = new Date();
            int date = (int)o;

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object[] arrS = new String[3];
            arrS[0] = new Integer(1);

        }
        catch (Exception e) {
            exceptions.add(e);
        }



    }
}
