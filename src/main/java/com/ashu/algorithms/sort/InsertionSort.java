package com.ashu.algorithms.sort;

public class InsertionSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        Sort s = new InsertionSort();
        Integer[] a = Sort.generateRandomIntArray(10);
        s.show(a);
        s.sort(a);
        s.show(a);
    }
}
