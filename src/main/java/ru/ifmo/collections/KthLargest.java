package ru.ifmo.collections;

import java.util.TreeMap;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final int k;
    private TreeMap<Integer, Integer> numbers;

    public KthLargest(int k, int[] numbers) {
        this.numbers = new TreeMap<>();
        this.k = k;
        for (int number : numbers) {
            put(number);
        }
    }

    public int add(int value) {
        put(value);
        int key = numbers.lastKey();
        int k = this.k;
        while (k > numbers.get(key)) {
            k -= numbers.get(key);
            key = numbers.lowerKey(key);
        }
        return key;
    }

    private void put(int value) {
        if (numbers.containsKey(value)) {
            numbers.put(value, numbers.get(value) + 1);
            return;
        }
        numbers.put(value, 1);
    }
}