package com.ashu.algorithms.tree;

import java.util.List;

public class BPlusNode<K extends Comparable<K>> {

  private boolean isLeaf;
  private boolean isRoot;

  private BPlusNode parent;

  private BPlusNode prev;
  private BPlusNode next;

  private List<K> keys;
  private List<BPlusNode<K>> children;

  public BPlusNode(boolean isLeaf, boolean isRoot) {
    this.isLeaf = isLeaf;
    this.isRoot = isRoot;
  }
}
