package com.ashu.algorithms.tree;

public class BTree<Key extends Comparable> {
  private BTNode root;
  private int order;

  public BTNode<Key> search(Key key) {
    BTNode prev = null;
    BTNode node = root;
    boolean found = false;

    int i = 0;
    while (node != null && !found) {
      i = node.index(key);
      if (node.getKeys().get(i).equals(key)) {
        found = true;
      } else {
//        prev = node;
        node = node.getChild(i);
      }
    }
    return found ? node : null;
  }



}
