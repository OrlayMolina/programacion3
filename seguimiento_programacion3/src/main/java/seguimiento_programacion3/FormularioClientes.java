package seguimiento_programacion3;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import seguimiento_programacion3.personas.Persona;
import seguimiento_programacion3.utilidades.TextFormatterUtil;


import java.io.IOException;
import java.util.List;
import static seguimiento_programacion3.core.BancoController.INSTANCE;


public class FormularioClientes {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnSalir;

    @FXML
    private TextField cedula;

    @FXML
    private TextField direccion;

    @FXML
    private TextField email;

    @FXML
    private TextField primerApellido;

    @FXML
    private TextField primerNombre;

    @FXML
    private TextField segundoApellido;

    @FXML
    private TextField segundoNombre;

    @FXML
    private TableColumn<Persona, String> colCedula;

    @FXML
    private TableColumn<Persona, String> tblEmail;

    @FXML
    private TableColumn<Persona, String> tblDireccion;

    @FXML
    private TableColumn<Persona, String> tblPrimerApellido;

    @FXML
    private TableColumn<Persona, String> tblPrimerNombre;

    @FXML
    private TableColumn<Persona, String> tblSegundoApellido;

    @FXML
    private TableColumn<Persona, String> tblSegundoNombre;

    @FXML
    private TableView<Persona> tblaClientes;


    @FXML
    public void initialize() {
        llenarTabla(INSTANCE.getBanco().buscar(null, null, null,null,
                null, null, null));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
        tblPrimerNombre.setCellValueFactory(new PropertyValueFactory<>("primerNombre"));
        tblSegundoNombre.setCellValueFactory(new PropertyValueFactory<>("segundoNombre"));
        tblPrimerApellido.setCellValueFactory(new PropertyValueFactory<>("primerApellido"));
        tblSegundoApellido.setCellValueFactory(new PropertyValueFactory<>("segundoApellido"));
        tblDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tblaClientes.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        cedula.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        primerNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        segundoNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        primerApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        segundoApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        direccion.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        email.setTextFormatter(new TextFormatter<>(TextFormatterUtil::lowerCaseFormat));
    }

    private void limpiarCampos() {
        cedula.setText("");
        primerNombre.setText("");
        segundoNombre.setText("");
        primerApellido.setText("");
        segundoApellido.setText("");
        direccion.setText("");
        email.setText("");
        llenarTabla(
                INSTANCE.getBanco().buscar(cedula.getText(), primerNombre.getText(), segundoNombre.getText(),
                        primerApellido.getText(), segundoApellido.getText(), direccion.getText(),email.getText())
        );
    }

    private void llenarTabla(List<Persona> persona) {
        tblaClientes.setItems(FXCollections.observableArrayList(persona));
        tblaClientes.refresh();
    }

    private void llenarCampos(Persona persona) {
        if (persona != null) {
            cedula.setText(persona.getNumeroDocumento());
            primerNombre.setText(persona.getPrimerNombre());
            segundoNombre.setText(persona.getSegundoNombre());
            primerApellido.setText(persona.getPrimerApellido());
            segundoApellido.setText(persona.getSegundoApellido());
            direccion.setText(persona.getDireccion());
            email.setText(persona.getCorreo());

        }
    }



    @FXML
    void onClickCancel(ActionEvent event) {
        limpiarCampos();
        tblaClientes.getSelectionModel().clearSelection();

    }

    @FXML
    void onClickCreate(ActionEvent event) {
        try {
            Persona persona = Persona.of(cedula.getText(), primerNombre.getText(), segundoNombre.getText() ,primerApellido.getText(), segundoApellido.getText(),direccion.getText(), email.getText());
            INSTANCE.getBanco().adicionarPersona(persona);
            llenarTabla(INSTANCE.getBanco().buscar(null, null, null, null, null, null,null));
            limpiarCampos();
            mostrarInformacion("La persona creada como cliente.");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }

    }

    @FXML
    void onClickDelete(ActionEvent event) {
        try {
            INSTANCE.getBanco().removerPersona(cedula.getText());
            llenarTabla(INSTANCE.getBanco().buscar(null, null, null, null, null, null,null));
            limpiarCampos();
            mostrarInformacion("La persona fue retirada del bus");

        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }

    }

    @FXML
    void onClickExit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("options.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Unibanco | Opciones generales");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void onClickSearch(ActionEvent event) {
        llenarTabla(
                INSTANCE.getBanco().buscar(cedula.getText(), primerNombre.getText(), segundoNombre.getText(),
                        primerApellido.getText(), segundoApellido.getText(), direccion.getText(),email.getText())
        );
    }

    @FXML
    void onClickUpdate(ActionEvent event) {

    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
