package com.ashu.algorithms.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Comparable {

  static class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      Arrays.sort(envelopes, new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {

          if (o1[0] == o2[0]) {
            return o2[1] - o1[1];
          } else {
            return o1[0] - o2[0];
          }
        }
      });

      int max = 0;
      int[][] dp = new int[envelopes.length][2];

      for (int[] envelope : envelopes) {
        int low = 0;
        int high = max;

        while (low < high) {
          int mid = low + (high - low) / 2;
          if (envelope[1] > dp[mid][1]) {
            low = mid + 1;
          } else {
            high = mid;
          }
        }

        dp[low] = envelope;

        System.out.print("low:" + low + " ");
        for (int[] ev : dp) {
          System.out.print(Arrays.toString(ev) + " ");
        }
        System.out.println();
        if (low == max) {
          max++;
        }
      }

      return max;
    }
  }

  public static void main(String[] args) {
    int[][] array = {
        {5,4},{6,4},{6,7},{2,3}
    };

    Arrays.sort(array, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
      }
    });

    for (int[] a : array) {
      System.out.println(Arrays.toString(a));
    }

    new Solution().maxEnvelopes(array);
  }
}
