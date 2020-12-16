package com.javarush.task.task23.task2305;

/* 
Inner
*/



public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];

        Solution sol = new Solution();
        sol.innerClasses[0] = sol.new InnerClass();
        sol.innerClasses[1] = sol.new InnerClass();
        solutions[0] = sol;

        sol = new Solution();
        sol.innerClasses[0] = sol.new InnerClass();
        sol.innerClasses[1] = sol.new InnerClass();
        solutions[1] = sol;

        return solutions;
    }

    public static void main(String[] args) {

    }
}
