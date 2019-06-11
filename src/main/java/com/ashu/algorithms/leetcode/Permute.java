package com.ashu.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permute {
  public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> subset = new ArrayList<>();
    for (int num : nums) {
      subset.add(num);
    }

    backtrack(0, subset, ans);
    return ans;

  }

  private void backtrack(int first, List<Integer> nums, List<List<Integer>> ans) {
//    System.out.println(first + "->" + " " + Arrays.toString(nums.toArray()));
    if (first == nums.size()) {
      System.out.println(nums);
      ans.add(new ArrayList<>(nums));
      return;
    }
//    System.out.println("first:" + first);
//    backtrack(first + 1, nums, ans);
    for (int i = first + 1; i < nums.size(); i++) {
      Collections.swap(nums, first, i);
//      System.out.println(first + "->" + i + " " + Arrays.toString(nums.toArray()));
      backtrack(first + 1, nums, ans);
      Collections.swap(nums, first, i);
//      System.out.println(first + "<-" + i);
    }

  }

  public static void main(String[] args) {
    int[] nums = new int[3];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }

    new Permute().permute(nums);
  }
}
