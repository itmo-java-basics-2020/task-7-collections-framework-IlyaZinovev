package ru.ifmo.collections;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private static final int NULL_RES = -1;

    private HashSet<Integer> unique; //contains numbers which are unique
    private ArrayDeque<Integer> numbers; //contains all numbers

    public FirstUnique(int[] numbers) {
        this.numbers = new ArrayDeque<>();
        unique = new HashSet<>();
        for (Integer number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        for (Integer number : numbers) {
            if (unique.contains(number)) {
                return number;
            }
        }
        return NULL_RES;
    }

    public void add(int value) {
        if (unique.contains(value)) {
            unique.remove(value); //delete number from set if it's not unique already
            return;
        }
        unique.add(value);
        numbers.add(value); //or add to unique and numbers
    }
}
