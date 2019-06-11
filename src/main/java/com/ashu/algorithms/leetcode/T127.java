package com.ashu.algorithms.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T127 {
  class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

      // 使用广度优先遍历的算法
      Set<String> dict = new HashSet<>(wordList);
      Set<String> front = new HashSet<>();
      front.add(beginWord);
      int len = 1;

      while (!front.isEmpty()) {
        if (front.contains(endWord)) {
          return len;
        }

        Set<String> newFront = new HashSet<>();
        // 广度优先遍历
        for (String item : front) {
          // 从26个字母中进行切换
          char[] chars = item.toCharArray();
          for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < chars.length; i++) {

              char t = chars[i];
              if (t == c) {
                continue;
              }
              chars[i] = c;
              String word = String.valueOf(chars);
              if (dict.contains(word)) {
                dict.remove(word);
                newFront.add(word);
              }
            }
          }

        }
        front = newFront;
        len++;
      }
      return 0;
    }
  }
}
