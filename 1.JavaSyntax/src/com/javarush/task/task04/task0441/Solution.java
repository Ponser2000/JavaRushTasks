package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        int n3 = Integer.parseInt(bufferedReader.readLine());



        if (n1<=n2 && n2<=n3)
            System.out.println(n2);
        else
        if (n1<=n3 && n3<=n2)
            System.out.println(n3);
        else
        if (n2<=n1 && n1<=n3)
            System.out.println(n1);
        else
        if (n2<=n3 && n3<=n1)
            System.out.println(n3);
        else
        if (n3<=n1 && n1<=n2)
            System.out.println(n1);
        else
        if (n3<=n2 && n2<=n1)
            System.out.println(n2);

    }
}
