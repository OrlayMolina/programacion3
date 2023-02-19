package seguimiento_programacion3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Inicio {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}