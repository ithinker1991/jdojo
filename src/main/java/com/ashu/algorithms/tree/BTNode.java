package com.ashu.algorithms.tree;

import java.util.List;
import lombok.Data;
import lombok.Getter;

/**
 * 1. m 阶
 * 2. 叶节点位于同一层
 * @param <K>
 */
@Data
public class BTNode<K extends Comparable<K>> {

  private int num = 0;

  // [children - 1, m]
  @Getter
  private List<K> keys;
  // if not root then [Math.floorDiv(m / 2), m] else [2,m]
  private List<BTNode<K>> children;
  private BTNode<K> parent;

  public int index(K k) {
    for (int i = 0; i < keys.size(); i++) {
      if (k.compareTo(keys.get(i)) <= 0) {
        return i;
      }
    }
    return num;
  }

  public BTNode<K> getChild(int index) {
    return children.get(index);
  }
}
