module com.example.seguimiento_programacion3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens seguimiento_programacion3 to javafx.fxml;
    exports seguimiento_programacion3;
}