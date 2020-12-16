package com.javarush.task.task11.task1123;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }
        int[] copy= Arrays.copyOf(inputArray,inputArray.length);

        for(int i=0;i<copy.length; i++)
            for(int j=0;j<copy.length; j++) {
                if (copy[i]<copy[j]) {
                    int n = copy[i];
                    copy[i]=copy[j];
                    copy[j]=n;
                }
            }

        return new Pair<Integer, Integer>(copy[0], copy[copy.length-1]);
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
