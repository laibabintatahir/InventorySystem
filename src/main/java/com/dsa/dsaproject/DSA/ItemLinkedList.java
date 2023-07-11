package com.dsa.dsaproject.DSA;

import com.dsa.dsaproject.entities.InventoryItem;

public class ItemLinkedList {
    private class Node {
        private InventoryItem value;
        private Node next;
        public Node(InventoryItem value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    public void add(InventoryItem value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void display() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println("Item ID: " + currentNode.value.getCode());
            System.out.println("Name: " + currentNode.value.getName());
            System.out.println("Description: " + currentNode.value.getDescription());
            System.out.println("Price: " + currentNode.value.getProductPrice());
            System.out.println();
            currentNode = currentNode.next;
        }
    }


    public void remove(InventoryItem value) {
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode != null) {
            if (currentNode.value == value) {
                if (previousNode == null) {
                    head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
}