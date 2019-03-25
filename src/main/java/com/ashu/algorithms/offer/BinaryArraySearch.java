package com.ashu.algorithms.offer;

public class BinaryArraySearch {
    public boolean Find(int target, int [][] array) {
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = array[0].length - 1;
        int colEnd = array.length - 1;


        return Find(target, array, rowStart, rowEnd, colStart, colEnd);

    }

    boolean Find(int target, int[][] array,int rowStart,int rowEnd,int colStart,int colEnd) {
        if (rowStart == rowEnd && colStart == colEnd) {
            return false;
        }

        if (rowStart < rowEnd || colStart < colEnd) {
            return false;
        }
        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;
        int midValue = array[rowMid][colMid];
        if (midValue == target) {
            return true;
        } else if (midValue > target) {
            return Find(target, array, rowStart, rowMid - 1, colMid + 1, colEnd) ||
                    Find(target, array, rowMid, rowEnd, colMid, colEnd);
        } else {
            return Find(target, array, rowStart, rowMid, colStart, colMid) ||
                    Find(target, array, rowMid + 1, rowEnd, colStart, colMid - 1);
        }


    }

    public static void f(Integer i) {
        i++;
    }

    static class IntHolder {
        int i;
        IntHolder(int i) {
            this.i = i;
        }
        void increase() {
            i++;
        }
        int get() {
            return i;
        }
    }

    public static void main(String[] args) {
        IntHolder i = new IntHolder(0);
        i.increase();


    }
}
