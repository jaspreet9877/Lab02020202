module com.example.jaspreet {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.jaspreet to javafx.fxml;
    exports com.example.jaspreet;
}