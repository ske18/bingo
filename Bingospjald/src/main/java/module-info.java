module com.example.bingospjald {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vidmot to javafx.fxml;
    exports com.example.vidmot;
}