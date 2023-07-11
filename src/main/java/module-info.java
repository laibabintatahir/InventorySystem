module com.dsa.dsaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.dsa.dsaproject to javafx.fxml;
    opens com.dsa.dsaproject.entities to javafx.base;
    opens com.dsa.dsaproject.database to javafx.base;
    exports com.dsa.dsaproject;
}