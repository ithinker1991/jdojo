package com.ashu.algorithms.leetcode;

public class T223 {

  public static void main(String[] args) {
    int ret = new Solution().computeArea(-1500000001, 0, -1500000000, 1,
                                         1500000000, 0, 1500000001, 1);
    System.out.println(ret);
  }
}

class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

    int area1 = (C - A) * (D - B);
    int area2 = (G - E) * (H - F);
    int x = Math.min(C, G) - Math.max(A, E);
    int y = Math.min(D, H) - Math.max(B, F);

    int overlap = 0;

    //
     if(Math.min(C, G) > Math.max(A, E) && Math.min(D, H) > Math.max(B, F)){
         overlap = x * y;
     }

    System.out.println("x:" + x + " y:" + y + " overlap:" + overlap);
    System.out.println("Math.min(C, G):" + Math.min(C, G) + " Math.max(A, E):" + Math.max(A, E));
    System.out.println("Math.min(D, H):" + Math.min(D, H) + " Math.max(B, F):" + Math.max(B, F));
    System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE) ;

    String s = "ss ";
    s.trim();
    StringBuilder sb = new StringBuilder();
    sb.reverse();

    int i1 = 1500000000;
    int i2 = 1500000000;

    System.out.println(i1 + i2);

    return area1 + area2 - overlap;
  }
}