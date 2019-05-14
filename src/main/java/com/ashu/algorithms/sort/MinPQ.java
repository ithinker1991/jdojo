package com.ashu.algorithms.sort;

import java.util.Arrays;

public class MinPQ<Key extends Comparable<Key>> {

    private int capacity;
    private int size;
    // left > right
    private Key[] data;
    public MinPQ(int capacity) {
        this.capacity = capacity;
        data = (Key[]) new Comparable[capacity + 1];
        this.size = 0;
    }

    private void insert(Key key) {
        data[++size] = key;
        swim(size);
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    private void exch(int i, int j) {
        Key tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private Key delMin() {
        Key min = data[1];
        exch(1, size--);
        sink(1);
        return min;
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if ( j < size && !less(j, j+1)) {
                j++;
            }

            if (!less(k, j)) {
                exch(k, j);
                k = j;
            } else {
                break;
            }
        }
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    public static void main(String[] args) {
        int capacity = 10;
        MinPQ<Integer> m = new MinPQ<>(capacity);

        for (int i = 0; i < capacity; i++) {
            int random = (int) (Math.random() * 100);
            System.out.print(random + " ");
            m.insert(random);
        }

        System.out.println();
        System.out.println(m.toString());

        for (int i = 0; i < capacity; i++) {
            System.out.println(m.delMin());
            System.out.println(m.toString());
        }
    }



}
