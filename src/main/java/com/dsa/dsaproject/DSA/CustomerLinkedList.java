package com.dsa.dsaproject.DSA;

import com.dsa.dsaproject.entities.Customer;

public class CustomerLinkedList {
    private class Node {
        private Customer data;
        private Node next;

        public Node(Customer data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void add(Customer data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void display() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println("Customer ID: " + currentNode.data.getcID());
            System.out.println("Customer Code: " + currentNode.data.getCustomerCode());
            System.out.println("Full Name: " + currentNode.data.getFullName());
            System.out.println("Location: " + currentNode.data.getLocation());
            System.out.println("Phone: " + currentNode.data.getPhone());
            System.out.println();

            currentNode = currentNode.next;
        }
    }


    public void remove(Customer data) {
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode != null) {
            if (currentNode.data == data) {
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
