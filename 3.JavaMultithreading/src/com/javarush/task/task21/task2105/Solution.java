package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Solution))
            return false;

        Solution m = (Solution) o;

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
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
