package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n==null)
            return false;

        if (!(n instanceof Solution))
            return false;

        if (this == n) return true;


        if (n.getClass() != this.getClass()) {
            return false;
        }


        Solution m = (Solution) n;

        if (m.first == null && this.first == null && m.last == null && this.last == null) return true;
        if (m.first == null && this.first == null && m.last == this.last) return true;
        if (m.first == this.first && m.last == null && this.last == null) return true;

        return m.first == this.first && m.last == this.last;
    }

    public int hashCode() {
        if (this.first == null && this.last == null) return 0;

        if (this.first == null) return 31 * (0 + this.last.length());

        if (this.last == null) return 31 * (this.first.length() + 0);

        return 13 * (this.first.length() + this.last.length());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
