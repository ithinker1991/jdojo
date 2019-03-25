package com.ashu.algorithms.offer;

import java.util.ArrayList;
import java.util.List;

public class TopK {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 4,4,1,6,2,7,3,8
        // 4,4,1,3,2,7,6,8
        // 2,4,1,3,4,7,6,8
        int low = 0;
        int high = input.length - 1;
        int mid = parition(input, low, high);
        while (mid + 1 != k) {
            if (mid + 1 > k) {
                high = mid;
            } else {
                low = mid + 1;
            }
            if (low == high) break;
            mid = parition(input, low, high);
        }
        System.out.println("mid:" + mid);
        ArrayList<Integer> result = new ArrayList<>();


        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }



    public int parition(int[] input, int low, int high) {
        System.out.println("parition");
        for (int i : input) {
            System.out.print(i + " ");
        }

        System.out.println();

        // int key = input[low];
        System.out.println("low:" + " " + low + " high:" + high);
        int i = low;
        int j = high + 1;
        int key = input[low];

        while(true) {
            while (input[++i] < key) {
                if (i == high) break;
            }

            while (input[--j] > key) {
                if (j == low) break;
            }

            if (i >= j) break;
            swap(input, i, j);
        }
        // 肯定会越过交界处
        swap(input, low, j);
        return j;
    }


    public void swap(int[] array, int i, int j) {
        System.out.println("swap "  + array[i] + " " + array[j]);
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();

        int[] array = {4,5,1,6,2,7,4,3,8};
//        System.out.println("fdsfsfsf");
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
        List<Integer> list = topK.GetLeastNumbers_Solution(array, array.length);

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
