module com.example.vlaknis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vlaknis to javafx.fxml;
    exports com.example.vlaknis;
}