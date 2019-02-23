package com.ashu.algorithms.offer;

public class MinNumberInRotateArray {

  public static int minNumberInRotateArray(int [] array) {
    if (array.length == 0) return 0;
//    return findMin(array, 0, array.length - 1);
    int low = 0;
    int high = array.length - 1;
    int mid = 0;
    while(array[low] >= array[high]) {
      if (high - low == 1) {
        mid = high;
        break;
      }

      mid = low + (high - low) / 2;
      if (array[mid] >= array[low] ) {
        low = mid;
      } else if (array[mid] <= array[high]) {
        high = mid;
      }
    }
    return array[mid];
  }
//
//  public static int findMin(int[] array, int start, int end) {
//    if (start == end) return array[start];
//    if (array[start] <= array[end]) {
//      return array[start];
//    } else {
//      int mid = (start + end) / 2;
//      int left = findMin(array, start, mid);
//      int right = findMin(array, mid + 1, end);
//      return left <= right ? left : right;
//    }
//  }
  public static void main(String[] args) {
    int[] array = {7, 8,6873, 1, 1, 2, 4, 5};
    System.out.println(minNumberInRotateArray(array));
  }

}
