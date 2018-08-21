package com.ashu.algorithms.string.trie;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;


public class Trie<Value> {
    private static int TABLE_SIZE = 256;
    private static class Node{
        private Object val;
        private Node[] next = new Node[TABLE_SIZE];
    }

    public Trie(Object val) {
        root = new Node();
        root.val = val;
    }

    public Trie() {
        root = new Node();
    }

    private Node root;

    public Value get(String s) {
        Node x =  get(root, s, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    public Node get(Node node, String s, int i) {
        if (node == null) {
            return null;
        }
        if (i == s.length()) return node;
        char c = s.charAt(i);
        return get(node.next[c], s, i+1);
    }

    public void put(String s, Value val) {
        root = put(root, s, val, 0);
    }

    public Node put(Node node, String s, Value val, int i) {
        if (node == null) {
            node = new Node();
//            node.val = val;
        }
        if (i == s.length()) {
            node.val = val;
            return node;
        }
        char c = s.charAt(i);
        node.next[c] = put(node.next[c], s, val, i + 1);
        return node;
    }

    public static void testBaic() {
        Trie<String> tree = new Trie<>();
        for (int i = 0; i < 100; i++) {
            String key = "item" + i;
            String val = key.concat("val");
            tree.put(key, val);
        }

        for (int i = 0; i < 100; i++) {
            String key = "item" + i;
            System.out.println("GET, key:" + key);
            String val = tree.get(key);
            String expected = key.concat("val");
            Assert.assertEquals(val, expected);
        }
    }

    public boolean contains(String key) {
        Node node = get(root, key, 0);
        return node != null;
    }

    public boolean isEmpty() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (root.next[i] != null) {
                return false;
            }
        }
        return true;
    }

    public String longestPrefixOf(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        int i = 0;
        Node node = get(root, s.substring(i, i + 1), 0);
        if (node == null) {
            return null;
        }
        i++;
        while (i < s.length() - 1) {
            node = get(node, s.substring(i, i+1), 0);
            if (node == null) {
                return s.substring(0, i);
            }
            i++;
        }
        return  s;
    }


    public static void testCreateTrie() {
        String[] table = {"she", "sells", "shells", "by", "the", "shore"};
        Trie<Integer> trie = new Trie<>();

        for (int i = 0; i < table.length; i++) {
            trie.put(table[i], i);
        }

        for (int i = 0; i < table.length; i++) {
            int actual = trie.get(table[i]);
            Assert.assertEquals(actual, i);
        }
    }

    public static void testContains() {
        String[] table = {"she", "sells", "shells", "by", "the", "shore"};
        String[] tableNotInTrie = {"shess", "sellsss", "shlls", "bsy", "tshe", "shofre"};
        Trie<Integer> trie = new Trie<>();

        for (int i = 0; i < table.length; i++) {
            trie.put(table[i], i);
        }

        for (int i = 0; i < tableNotInTrie.length; i++) {
            Assert.assertFalse(trie.contains(tableNotInTrie[i]));
        }

        for (int i = 0; i < table.length; i++) {
            Assert.assertTrue(trie.contains(table[i]));
        }
    }

    public static void testIsEmpty() {
        Trie<String> trie = new Trie<>();
        Assert.assertTrue(trie.isEmpty());
        trie.put("key", "value");
        Assert.assertFalse(trie.isEmpty());
    }

    public static void main(String[] args) {
        testBaic();
        testCreateTrie();
        testContains();
        testIsEmpty();

    }
}
