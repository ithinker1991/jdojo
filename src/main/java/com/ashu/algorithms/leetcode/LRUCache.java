package com.ashu.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /*

    0. 看题
    1. 分析：这道题的核心就是利用两个数据结构进行仿照
        1. 链表，用于存放数据，
        2. HashMap，用于存放 Key 所在链表的 Node
        3. 对数据的增删，也涉及到链表的删除，添加操作
    2. 过 case
       act    put1,1  put2,2  get1   put3,3  get2
       map    1,1     2,2
       list   1       2->1    1->2   3->1
       size   1       2       2      2
    */

    class Node {
        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

        Node(){}

        Node prev;
        Node next;
        int val;
        int key;
    }

    Map<Integer, Node> map;
    Node tail;
    Node head;
    int capacity;
    int size;


    // head <-> node1 <-> node2 <-> ... -> tail
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        tail = new Node();
        head = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // System.out.println("get(" + key +")" );

        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }

    }

    private void moveToHead(Node node) {
        remove(node);
        addNode(node);
    }

    private void addNode(Node node) {
        Node headNext = head.next;
        headNext.prev = node;
        head.next = node;

        node.prev = head;
        node.next = headNext;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
        }
    }

    public void put(int key, int value) {
        // System.out.println("put(" + key + "," + value + ")" );
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            node.val = value;
        } else {
            Node node = new Node(key, value);
            addNode(node);
            size++;
            map.put(key, node);

            if (size > capacity) {
                Node prev = tail.prev;
                map.remove(prev.key);
                remove(prev);
                size--;
            }
        }
    }

    public void printList() {
        Node p = head;
        int a = 0;
        int b = 0;



        while (p != null) {
            System.out.print("(" +  p.key  +  ") -> ");
            p = p.next;
        }
        System.out.println();

        p = tail;
        while (p != null) {
            System.out.print("(" +  p.key  +  ") <- ");
            p = p.prev;
        }
        System.out.println();
        System.out.println("size=" + size);
    }
    static public int reverse(int x) {
        int ret = 0;

        while (x != 0) {

            if (Integer.MAX_VALUE - ret * 10 < x % 10 || Integer.MIN_VALUE - ret * 10 > x % 10) {
                System.out.println(Integer.MIN_VALUE);
                System.out.println(Integer.MIN_VALUE - ret * 10);
                System.out.println(ret * 10);
                System.out.println(x % 10);
                System.out.println(Integer.MIN_VALUE - ret * 10 > x % 10);


                return 0;
            }
            ret = ret * 10 + x % 10;
            x = x / 10;
        }

        return (int)ret;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
