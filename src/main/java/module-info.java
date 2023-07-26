module com.example.isscan {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.isscan to javafx.fxml;
    opens com.example.isscan.controllers to javafx.fxml;
    exports com.example.isscan;
}