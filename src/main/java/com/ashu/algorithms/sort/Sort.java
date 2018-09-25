package com.ashu.algorithms.sort;

public abstract class Sort {

    // sort
    public abstract void sort(Comparable[] a);

    // exch
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // show
    public void show(Comparable[] a) {
        for (Comparable v: a) {
            System.out.printf(v.toString() + " ");
        }
        System.out.println("");
    }

    // less
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // isSorted
    public boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length-1 ; i++) {
            if (!less(a[i], a[i+1])) {
                return false;
            }
         }
         return true;
    }

    public static Integer[] generateRandomIntArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            int v = (int)(Math.random() * 100);
            a[i] = v;
        }
        return  a;
    }

}
