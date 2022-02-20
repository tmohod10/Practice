module com.example.contactapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.contactapp to javafx.fxml;
    opens com.example.contactapp.datamodel;
    exports com.example.contactapp;
}