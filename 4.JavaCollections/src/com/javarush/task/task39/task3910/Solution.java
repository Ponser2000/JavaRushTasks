package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(6));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(26));

    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1)
        {
            return false;
        }
        if (n == 1)
        {
            return true;
        }
        int c = 1;
        do {
            c = c * 3;
        } while (c < n);

        return c == n ? true : false;
    }
}
