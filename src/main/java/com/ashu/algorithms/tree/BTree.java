package com.ashu.algorithms.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BTree<K extends Comparable> {
  private BTNode root;
  private int order;

  public  BTNode search(K k) {
    BTNode prev = null;
    BTNode node = root;
    boolean found = false;

//    return node.getKeys().get(0);

//    int i = 0;
//    while (node != null && !found) {
//      i = node.index(k);
//      if (node.getKeys().get(i).equals(k)) {
//        found = true;
//      } else {
////        prev = node;
//        node = node.getChild(i);
//      }
//    }
//    return found ? node : null;
    return null;
  }
 }


