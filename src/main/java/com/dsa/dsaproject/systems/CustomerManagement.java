package com.dsa.dsaproject.systems;

import com.dsa.dsaproject.DSA.CustomerBST;
import com.dsa.dsaproject.DSA.CustomerLinkedList;
import com.dsa.dsaproject.entities.Customer;

public class CustomerManagement {
    private CustomerBST bst;
    private CustomerLinkedList linkedList;

    public CustomerManagement() {
        this.bst = new CustomerBST();
        this.linkedList = new CustomerLinkedList();

    }

    public void addItem(Customer customer) {
        bst.insert(Integer.parseInt(String.valueOf(customer.getcID())), customer);
        linkedList.add(customer);
    }

    public Customer searchItem(String customerID) {
        return bst.search(Integer.parseInt(customerID));
    }

    public void displayInventory() {
//        System.out.println("Inventory Items (BST):");
//        bst.displayInOrder();

        System.out.println("Inventory Items (LinkedList):");
        linkedList.display();
    }

    public void deleteItem(String customerID) {
        Customer customer = bst.search(Integer.parseInt(customerID));
        if (customer != null) {
            bst.delete(Integer.parseInt(customerID));

            System.out.println("Customer with ID " + customerID + " has been deleted.");
        } else {
            System.out.println("Customer with ID " + customerID + " does not exist.");
        }
    }
}
