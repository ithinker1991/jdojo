package com.ashu.proj.Bloom;

import java.util.BitSet;

public class BloomFilter {

//   TODO 应该是位数组
//  private static final int [] = new int[]




    private BitSet bits;
    private static final int DEFAULT_SIZE = 2 << 24;

    public BloomFilter() {
      this(DEFAULT_SIZE);
    }

    public BloomFilter(int size) {
      bits = new BitSet(size);
    }

    public void add(String val) {

    }

    public boolean contains(String val) {
      return false;
    }

    public int hash(String val) {
      int ret = 0;
      return 1;
    }

}
