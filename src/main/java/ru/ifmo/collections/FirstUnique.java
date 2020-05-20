package ru.ifmo.collections;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    static final int NULL_RES = -1;

    private HashSet<Integer> Unique;
    private ArrayDeque<Integer> numbers;

    public FirstUnique(int[] numbers) {
        this.numbers = new ArrayDeque<>();
        Unique = new HashSet<>();
        for (Integer number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        for (Integer number : numbers) {
            if (Unique.contains(number)) {
                return number;
            }
        }
        return NULL_RES;
    }

    public void add(int value) {
        if (Unique.contains(value)) {
            Unique.remove(value);
            return;
        }
        Unique.add(value);
        numbers.add(value);
    }
}
