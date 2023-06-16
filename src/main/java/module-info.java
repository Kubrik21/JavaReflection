module com.example.javareflectionexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javareflectionexample to javafx.fxml;
    exports com.example.javareflectionexample;
}