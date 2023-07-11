package com.dsa.dsaproject.entities;

public class InventoryItem {

    private int productID;
    private String Code;
    private String Name;
    private String Description;
    private String productPrice;
//    Write all setter getters
    public InventoryItem(int productID, String Code, String Name, String Description, String productPrice) {
        this.productID = productID;
        this.Code = Code;
        this.Name = Name;
        this.Description = Description;
        this.productPrice = productPrice;
    }

    public InventoryItem() {
    }

    public int getProductID() {
        return productID;
    }

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "productID=" + productID + ", Code=" + Code + ", Name=" + Name + ", Description=" + Description + ", productPrice=" + productPrice + '}';
    }
}
