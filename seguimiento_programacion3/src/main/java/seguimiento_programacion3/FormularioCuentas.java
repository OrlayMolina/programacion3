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
import seguimiento_programacion3.core.Cuenta;
import seguimiento_programacion3.core.CuentaAhorro;
import seguimiento_programacion3.core.CuentaCorriente;
import seguimiento_programacion3.exceptions.PersonaNoExisteException;
import seguimiento_programacion3.personas.Cliente;
import seguimiento_programacion3.personas.Persona;

import seguimiento_programacion3.utilidades.TextFormatterUtil;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static seguimiento_programacion3.core.BancoController.INSTANCE;

public class FormularioCuentas {

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
    private ComboBox<CuentaAhorro> cmBox;

    @FXML
    private TextField fldNumeroCuenta;

    @FXML
    private TextField fldSaldo;

    @FXML
    private TextField fldTitularCuenta;

    @FXML
    private TableColumn<Cuenta, String> colNumeroCta;

    @FXML
    private TableColumn<Cuenta, String> colSaldo;

    @FXML
    private TableColumn<Cuenta, CuentaAhorro> colTipoCta;

    @FXML
    private TableColumn<Persona, String> colTItular;

    @FXML
    private TableView<Cuenta> tblCuentas;

    @FXML
    public void initialize() {
        llenarTabla(INSTANCE.getBanco().buscarCuenta(null, null, null));
        colTItular.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colNumeroCta.setCellValueFactory(new PropertyValueFactory<>("numeroCta"));
        colTipoCta.setCellValueFactory(new PropertyValueFactory<>("tipoCuenta"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblCuentas.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        fldTitularCuenta.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        fldNumeroCuenta.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        fldSaldo.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));

    }

    private void limpiarCampos() {
        fldNumeroCuenta.setText("");
        fldTitularCuenta.setText("");
        fldSaldo.setText("");
        cmBox.setValue(null);
    }

    private void llenarTabla(List<Cuenta> cuenta) {
        tblCuentas.setItems(FXCollections.observableArrayList(cuenta));
        tblCuentas.refresh();
    }

    private void llenarCampos(Cuenta cuenta) {
        if (cuenta != null) {
            fldNumeroCuenta.setText(cuenta.getNumeroCta());
            fldTitularCuenta.setText(String.valueOf(cuenta.getCliente()));
            fldSaldo.setText(String.valueOf(cuenta.getSaldo()));



        }
    }

    @FXML
    void onClicUdpate(ActionEvent event) {

    }

    @FXML
    void onClickCancel(ActionEvent event) {
        limpiarCampos();
        tblCuentas.getSelectionModel().clearSelection();
    }

    @FXML
    void onClickDelete(ActionEvent event) {

        /*try {
            INSTANCE.getBanco().removerCuenta(fldNumeroCuenta.getText());
            llenarTabla(INSTANCE.getBanco().buscar(null, null, null, null ));
            limpiarCampos();
            mostrarInformacion("Cuenta eliminada exitosamente.");

        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }*/

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
    void onClickSave(ActionEvent event) {

        try {
            String nombreTitular = fldTitularCuenta.getText();
            Optional<Persona> cliente = INSTANCE.getBanco().buscarPorNumeroIdentificacion(nombreTitular);
            if (cliente.isEmpty()) {
                throw new PersonaNoExisteException();
            }
            Cuenta cuenta = Cuenta.of(fldNumeroCuenta.getText(), (Cliente) cliente.get(),fldSaldo.getText());
            INSTANCE.getBanco().adicionarCuenta(cuenta);
            llenarTabla(INSTANCE.getBanco().buscarCuenta(null, null, null));
            limpiarCampos();
            mostrarInformacion("La cuenta fue creada.");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }

    }

    @FXML
    void onClickSearch(ActionEvent event) {
        llenarTabla(
                INSTANCE.getBanco().buscarCuenta(fldNumeroCuenta.getText(), fldTitularCuenta.getText() ,fldSaldo.getText())
        );
    }

    @FXML
    void onClickTipoCuenta(ActionEvent event) {

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
