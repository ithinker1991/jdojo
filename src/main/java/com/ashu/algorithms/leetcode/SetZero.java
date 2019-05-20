package com.ashu.algorithms.leetcode;

import java.util.Arrays;
import javax.xml.bind.SchemaOutputResolver;

public class SetZero {

  public static class Solution {
    public void setZeroes(int[][] matrix) {
      // 先遍历一遍，记下有哪些行和列需要重置为0
      // 开始重置

      int zeroCol = -1;
      int zeroRow = -1;
      for (int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
          if (matrix[i][j] == 0 && i != zeroCol && j != zeroRow) {
            if (zeroCol == -1) {
              zeroCol = i;
              zeroRow = j;
              for (int m = 0; m < matrix[0].length; m++) {
                matrix[zeroCol][m] = 0;
              }

              for (int n = 0; n < matrix[0].length; n++) {
                matrix[n][zeroRow] = 0;
              }
            } else {
              matrix[zeroCol][j] = 1;
              matrix[i][zeroRow] = 1;
            }
          }
        }
      }

      if (zeroCol == -1) return;


      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
          if (matrix[i][j] != 0 && i != zeroCol && j != zeroRow) {
            if (matrix[zeroCol][j] == 1 || matrix[i][zeroRow] == 1) {
              matrix[i][j] = 0;
            }
          }
        }
      }

      for (int m = 0; m < matrix[0].length; m++) {
        matrix[zeroCol][m] = 0;
      }

      for (int n = 0; n < matrix[0].length; n++) {
        matrix[n][zeroRow] = 0;
      }

    }

//    void printMatrix(int[][] matrix) {
//      for (int i = 0; i < matrix.length; i++) {
//        for (int j = 0; j < matri)
//      }
//    }
  }



  public static void main(String[] args) {
    String s = "abc";
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE * -1);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MIN_VALUE * -1);

    double  i = 3.14 % 1;
    System.out.println(i);
    System.out.println(Math.log(243) / Math.log(3)  % 1 <  0.000000000001);
    System.out.println(Math.log(243) / Math.log(3) % 1);

    long treePow = 1;

    while (treePow * 3 < Integer.MAX_VALUE) {
      treePow *= 3;
    }

    System.out.println("treePow:" + treePow);

    "".indexOf("fsdf");
    System.out.println(s.substring(2, 1 + 1).length());
//    int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//    Solution s = new Solution();
//    s.setZeroes(matrix);



  }
}
