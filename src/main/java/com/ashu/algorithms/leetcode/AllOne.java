package com.ashu.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

class AllOne {

    /** Initialize your data structure here. */
    /*
    分析：
    1. 要想要 O(1) 能够取出数据，肯定要用 HashMap
    2. 如果想要快速修改，用链表存放数据
    */

    class Node {
        String key;
        int val;
        Node next;
        Node prev;
        Node(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<String, Node> map = new HashMap<>();

    Node head;
    Node tail;
    public AllOne() {
        head = new Node(null, Integer.MAX_VALUE);
        tail = new Node(null, Integer.MIN_VALUE);

        head.next = tail;
        tail.prev = head;
    }
    // head                tail
    // 5 -> 4 -> 4 -> 4 ->

    private void insert(Node node, Node prev, Node next) {
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node) {
        Node prev = node.prev;
        while (node.val > prev.val) {
            remove(node);
            insert(node, node.prev.prev, node.prev);
            prev = node.prev;
        }
    }

    private void moveToTail(Node node) {
        Node next = node.next;
        while (node.val < next.val) {
            remove(node);
            insert(node, node.next, node.next.next);
            next = node.next;
        }
    }



    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val++;
            moveToHead(node);
        } else {
            Node node = new Node(key, 1);
            insert(node, tail.prev, tail);
            map.put(key, node);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val--;

            if (node.val == 0) {
                remove(node);
                map.remove(key);
            } else {
                moveToTail(node);
            }
        } else {
            // do nothing;
        }

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {

        if (head.next != tail) {
            return head.next.key;
        } else {
            return "";
        }

    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (tail.prev != head) {
            return tail.prev.key;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        AllOne ao = new AllOne();
//        ["AllOne","getMaxKey","inc","inc","getMinKey","getMaxKey"]
//        [[],[],["1"],["1"],[],[]]
        ao.inc("1");
        ao.inc("1");
        ao.inc("1");
        ao.inc("3");
        ao.inc("2");
        ao.inc("1");
        ao.inc("3");
        ao.inc("3");
        ao.inc("3");
        ao.inc("3");
        ao.inc("3");
        ao.inc("3");
        ao.inc("3");
        ao.inc("3");
        ao.inc("3");
        ao.inc("1");
        ao.inc("2");
        System.out.println(ao.getMaxKey());
        System.out.println(ao.getMinKey());
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */