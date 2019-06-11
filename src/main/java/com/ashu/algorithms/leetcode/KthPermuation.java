package com.ashu.algorithms.leetcode;

import java.util.Arrays;

public class KthPermuation {

  static class Solution {
    public String getPermutation(int n, int k) {

      int[] points = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};
      int[] mark = new int[n+1];
      int ret = 0;
      k--;
      for (int i = 1; i <= n; i++) {
        // 子循环中第cnt个
        int cnt = k / points[n-i];
        k = k % points[n-i];

        int num = 1;

        while (mark[num] == 1) num++;

        while (cnt > 0) {
          if (mark[num] == 1) {
            num++;
          } else {
            num++;
            cnt--;
          }
        }
        mark[num] = 1;
        ret = ret * 10 + num;
        System.out.println("num:" + num + " cnt:" + cnt + " " + Arrays.toString(mark));

        System.out.println(ret);
      }
      return ret + "";
    }
  }

  public static void main(String[] args) {
    new Solution().getPermutation(3, 3);
  }

}
