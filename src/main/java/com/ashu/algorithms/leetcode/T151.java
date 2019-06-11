package com.ashu.algorithms.leetcode;

public class T151 {
  class Solution {
    public String reverseWords(String s) {
      char[] arr = s.toCharArray();
      String[] strs = s.trim().split("\\s");
      StringBuilder sb = new StringBuilder();

      for (int i = strs.length - 1; i >= 0; i--) {
        if (sb.length() != 0) {
          sb.append(" ");
        }
        sb.append(strs[i].trim());
      }
      return sb.toString();
    }

    private void reverse(char[] arr, int i, int j) {
      char tmp;
      while (i < j) {
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    }
  }

  public static void main(String[] args) {
    new T151().new Solution().reverseWords("");
  }

}
