package com.ashu.concurrent.lock;

import scala.Int;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public int[] chooseFactors(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target / nums[i], i);
            }
        }
        return new int[0];
    }

    public int maxEaring(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int minPrice = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int price = nums[i];
            if (price < minPrice) {
                minPrice = price;
            } else {
                max = Math.max(max, price - minPrice);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int size = 10;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = (int) (Math.random() * 100);
        }

        ReentrantLock lock = new ReentrantLock();


    }
}
