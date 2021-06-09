package com.company;

import java.util.LinkedList;
import java.util.List;

public class MyTreeMap<A extends Comparable<A>, B> {
    private Node<A, B> root;
    private class Node<K extends A, V extends B> {
        K key;
        V value;
        Node<K,V> left;
        Node<K,V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public B put(A key, B value) {
        if (root == null) {
            root = new Node<>(key, value);
            return null;
        }
        return addUtil(root, key, value);
    }

    private B addUtil(Node<A,B> node, A key, B value) {
        if (node.key.compareTo(key) == 0) {
            B temp = node.value;
            node.value = value;
            return temp;
        }
        if (node.key.compareTo(key) > 0) {//Вправо
            if (node.right != null) {
                return addUtil(node.right, key, value);
            }
            node.right = new Node<>(key, value);
            return null;
        }
        if (node.key.compareTo(key) < 0) {//Влево
            if (node.left != null) {
                return addUtil(node.left, key, value);
            }
            node.left = new Node<>(key, value);
            return null;
        }
        return null;
    }

    public B get(A key) {
        return getUtil(root, key);
    }

    private B getUtil(Node<A,B> node, A key) {
        if (node == null) return null;
        if (node.key.compareTo(key) == 0) {
            return node.value;
        }
        if (node.key.compareTo(key) > 0) {//Вправо
            if (node.right != null) {
                return getUtil(node.right, key);
            }
            return null;
        }
        if (node.key.compareTo(key) < 0) {//Влево
            if (node.left != null) {
                return getUtil(node.left, key);
            }
            return null;
        }
        return null;
    }

    public List<Pair<A,B>> entrySet() {
        List<Pair<A,B>> result = new LinkedList<>();
        entrySetUtil(root,result);
        return result;
    }

    private void entrySetUtil(Node<A, B> node, List<Pair<A,B>> list) {
        if (node == null) return;
        list.add(new Pair<A,B>(node.key, node.value));
        entrySetUtil(node.right, list);
        entrySetUtil(node.left, list);
    }
}
