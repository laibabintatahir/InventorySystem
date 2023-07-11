
package com.dsa.dsaproject.systems;

import com.dsa.dsaproject.DSA.BinarySearchTree;
import com.dsa.dsaproject.DSA.ItemLinkedList;
import com.dsa.dsaproject.entities.InventoryItem;

import java.util.LinkedList;

public class InventoryManagementSystem {
    private BinarySearchTree bst;
    private ItemLinkedList linkedList;

    public InventoryManagementSystem() {
        this.bst = new BinarySearchTree();
        this.linkedList = new ItemLinkedList();
    }

    public void addItem(InventoryItem item) {
        bst.insert(String.valueOf(item.getProductID()), item);
        linkedList.add(item);
    }

    public InventoryItem searchItem(String itemID) {
        return bst.search(itemID);
    }

    public void displayInventory() {
//        System.out.println("Inventory Items (BST):");
//        bst.displayInOrder();
        System.out.println("Inventory Items (LinkedList):");
        linkedList.display();


    }

    public void deleteItem(String itemID) {
        InventoryItem item = bst.search(itemID);
        if (item != null) {
            bst.delete(itemID);
            linkedList.remove(item);
            System.out.println("Item with ID " + itemID + " has been deleted.");
        } else {
            System.out.println("Item with ID " + itemID + " does not exist.");
        }
    }
}

