package com.ashu.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
  static class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ret = new ArrayList<>();
      backtrack1(nums, 0, new LinkedList<>(),ret);
      return ret;
    }
    void backtrack1(int[] nums, int start, LinkedList<Integer> curr, List<List<Integer>> ret) {
      System.out.println(start + " " + Arrays.toString(curr.toArray()));
      ret.add(new ArrayList<>(curr));
      if (start == nums.length) {
        return;
      }
      for (int i = start; i < nums.length; i++) {
//        curr.add(nums[i]);
//        backtrack1(nums, i + 1, curr, ret);
//        curr.removeLast();

        curr.add(nums[i]);
        backtrack1(nums, i + 1, curr, ret);
        curr.removeLast();
      }

      }

    void backtrack(int[] nums, int start, LinkedList<Integer> curr, List<List<Integer>> ret) {
      System.out.println(start + " " + Arrays.toString(curr.toArray()));
      ret.add(new ArrayList<>(curr));
      if (start == nums.length)
        return;
      for (int i = start; i < nums.length; i++) {
        curr.add(nums[i]);
        backtrack(nums, i + 1, curr, ret);
        curr.removeLast();
      }
    }
  }

  static class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> out = new ArrayList<>();
      subsets(nums, 0, new LinkedList<>(), out);
      return out;
    }

    void subsets(int[] nums, int index, LinkedList<Integer> list, List<List<Integer>> out ) {
      System.out.println(index + " " + Arrays.toString(list.toArray()));
      out.add(new ArrayList(list));
      if (index == nums.length)
        return;
      for (int i = index; i < nums.length; i++) {
        list.add(nums[i]);
        subsets(nums, i + 1, list, out);
        list.removeLast();
//        list.remove(list.size() - 1);
      }
    }


    public static void main(String[] args) {
      new Solution().subsets(new int[]{1, 2, 3});
      System.out.println("----");
      String s = null;
      System.out.println("" + s);
      new Solution1().subsets(new int[]{1, 2, 3});
      s = "" + s;
      System.out.println(s);
    }
  }

}
