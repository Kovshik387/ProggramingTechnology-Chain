module com.example.proggramingtechnologychain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proggramingtechnologychain to javafx.fxml;
    exports com.example.proggramingtechnologychain;
}