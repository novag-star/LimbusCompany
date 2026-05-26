package co.edu.uniquindio.poo.inmobilaria.controller;

import co.edu.uniquindio.poo.inmobilaria.model.Inmobilaria;
import co.edu.uniquindio.poo.inmobilaria.model.Comprador;
import co.edu.uniquindio.poo.inmobilaria.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistrationController {

    @FXML private TextField IDregistroW2;
    @FXML private TextField NombreRegistroW2;
    @FXML private TextField IdentificacionRegistroW2;
    @FXML private PasswordField ContraseñaRegistroW2;
    @FXML private TextField TelefonoRegistroW2;
    @FXML private TextField CorreoRegistroW2;
    @FXML private RadioButton radioComprador;
    @FXML private RadioButton radioVendedor;
    @FXML private ToggleGroup Entity;
    @FXML private Button btnRegistreseW2;


    private Inmobilaria inmobiliaria;

    public void setInmobiliaria(Inmobilaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    @FXML
    void ActionRegistroW2(ActionEvent event) {
        String idTexto = IDregistroW2.getText();
        String nombre = NombreRegistroW2.getText();
        String identificacion = IdentificacionRegistroW2.getText();
        String contrasenia = ContraseñaRegistroW2.getText();
        String telefono = TelefonoRegistroW2.getText();
        String correo = CorreoRegistroW2.getText();

        if (idTexto.isEmpty() || nombre.isEmpty() || identificacion.isEmpty() ||
                contrasenia.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            mostrarAlerta("Campos Vacíos", "Por favor, complete todos los campos.");
            return;
        }

        if (!radioComprador.isSelected() && !radioVendedor.isSelected()) {
            mostrarAlerta("Selección Obligatoria", "Por favor, seleccione si es Comprador o Vendedor.");
            return;
        }

        try {

            int id = Integer.parseInt(idTexto);
            boolean exito = false;


            if (radioComprador.isSelected()) {

                Comprador nuevoComprador = new Comprador(id, nombre, identificacion, contrasenia, telefono, correo, 0, "Sin especificar");
                exito = inmobiliaria.registrarusuario(nuevoComprador);
            } else if (radioVendedor.isSelected()) {
                Vendedor nuevoVendedor = new Vendedor(id, nombre, identificacion, contrasenia, telefono, correo, 0);
                exito = inmobiliaria.registrarusuario(nuevoVendedor);
            }

            if (exito) {
                mostrarAlerta("Registro Exitoso", "El usuario ha sido registrado correctamente.");
                regresarAlLogin();
            } else {
                mostrarAlerta("Error", "Ya existe un usuario con esa identificación.");
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de Formato", "El campo ID debe ser un número entero válido.");
        }
    }

    private void regresarAlLogin() {
        try {
            System.out.println("Regresando a la ventana de Logging.fxml...");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/inmobilaria/Logging.fxml"));
            Parent root = loader.load();


            LoggingController loggingController = loader.getController();
            if (loggingController != null) {
                loggingController.setInmobiliaria(this.inmobiliaria);
            }


            Stage stage = (Stage) btnRegistreseW2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            System.out.println(" ERROR: No se pudo cargar el archivo Logging.fxml");
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML void EventKeyContraseñaW2(KeyEvent event) {}
    @FXML void EventKeyCorreoW2(KeyEvent event) {}
    @FXML void EventKeyIDW2(KeyEvent event) {}
    @FXML void EventKeyNombreW2(KeyEvent event) {}
    @FXML void EventKeyTelefonoW2(KeyEvent event) {}
    @FXML void EventKeyidentificacionW2(KeyEvent event) {}
}