package com.dsa.dsaproject.DSA;

import com.dsa.dsaproject.entities.Customer;

public class CustomerBST {
    private class Node {
        private int key;
        private Customer value;
        private Node left;
        private Node right;

        public Node(int key, Customer value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(int key, Customer value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node root, int key, Customer value) {
        if (root == null) {
            root = new Node(key, value);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key, value);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, value);
        } else {
            System.out.println("Item with key " + key + " already exists.");
        }

        return root;
    }

    public Customer search(int key) {
        Node node = searchRec(root, key);
        return (node != null) ? node.value : null;
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
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
            System.out.println("Customer ID: " + root.value.getcID());
            System.out.println("Customer Code: " + root.value.getCustomerCode());
            System.out.println("Full Name: " + root.value.getFullName());
            System.out.println("Location: " + root.value.getLocation());
            System.out.println("Phone: " + root.value.getPhone());
            System.out.println();

            displayInOrderRec(root.right);
        }
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
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

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}
