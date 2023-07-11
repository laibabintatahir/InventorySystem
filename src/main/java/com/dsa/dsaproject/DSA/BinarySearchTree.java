package com.dsa.dsaproject.DSA;

import com.dsa.dsaproject.entities.InventoryItem;

public class BinarySearchTree {
    private class Node {
        private String key;private InventoryItem value;
        private Node left;
        private Node right;
        public Node(String key, InventoryItem value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node root;
    public void insert(String key, InventoryItem value) {
        root = insertRec(root, key, value);
    }
    private Node insertRec(Node root, String key, InventoryItem value) {
        if (root == null) {
            root = new Node(key, value);
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, value);
        } else {
            System.out.println("Item with key " + key + " already exists.");
        }
        return root;
    }
    public InventoryItem search(String key) {
        Node node = searchRec(root, key);
        return (node != null) ? node.value : null;
    }
    private Node searchRec(Node root, String key) {
        if (root == null || root.key.equals(key)) {
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }
    public void displayInOrder() {
        displayInOrderRec(root);
    }
    private void displayInOrderRec(Node root) {
        if (root != null) {
            displayInOrderRec(root.left);
            System.out.println("Item ID: " + root.value.getCode());
            System.out.println("Name: " + root.value.getName());
            System.out.println("Description: " + root.value.getDescription());
            System.out.println("Price: " + root.value.getProductPrice());
            System.out.println();


            displayInOrderRec(root.right);
        }
    }

   public void delete(String key){
        root = deleteRec(root, key);
    }
    private Node deleteRec(Node root, String key){
        if (root == null) {
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    private String minValue(Node root) {
        String minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;

   }

}
