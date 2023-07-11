package com.dsa.dsaproject;

import com.dsa.dsaproject.database.DbOperations;
import com.dsa.dsaproject.entities.InventoryItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductController implements Initializable {


    @FXML
    private TableView <InventoryItem> productTable;
    @FXML
    private TableColumn<InventoryItem, String> Code;

    @FXML
    private TableColumn<InventoryItem, String> Description;

    @FXML
    private TableColumn<InventoryItem, Integer> productID;

    @FXML
    private TableColumn<InventoryItem, String> Name;

    @FXML
    private TableColumn<InventoryItem, String> productPrice;
DbOperations db = new DbOperations();


    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        loadTable();

        System.out.println("Hello World");
    }


    public void loadTable() {
        InventoryItem [] inventoryItems = db.getAllProducts();
        ObservableList<InventoryItem> customerList = FXCollections.observableArrayList(inventoryItems);
        productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

        productTable.setItems(customerList);



    }

}
