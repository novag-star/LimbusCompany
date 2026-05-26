package co.edu.uniquindio.poo.inmobilaria.controller;

import co.edu.uniquindio.poo.inmobilaria.model.Inmobilaria;
import co.edu.uniquindio.poo.inmobilaria.model.Usuario;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class LoggingController {

    @FXML private TextField TxtUsuarioAquiLogging;
    @FXML private PasswordField TxtContraseñaAquiLogging;
    @FXML private Button btnIngreseLogging;
    @FXML private Button btnRegistreseLogging;

    private Inmobilaria inmobiliaria;

    public void setInmobiliaria(Inmobilaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    public LoggingController() {
    }

    @FXML
    void ActionIngreseW(ActionEvent event) {
        String cedulaDigitada = TxtUsuarioAquiLogging.getText();
        String contraseniaDigitada = TxtContraseñaAquiLogging.getText();

        if (cedulaDigitada.isEmpty()) {
            mostrarAlerta("Campos Vacíos", "Por favor, digite su número de identificación.");
            return;
        }

        Usuario usuarioLogueado = buscarUsuarioPorCedula(cedulaDigitada);

        if (usuarioLogueado != null) {
            try {
                if (usuarioLogueado instanceof Comprador) {
                    System.out.println("¡Bienvenido Comprador!: " + usuarioLogueado.getNombre());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/inmobilaria/SistemaCompradores.fxml"));
                    Parent root = loader.load();

                    SistemaCompradoresController controller = loader.getController();
                    controller.setInmobiliariaYComprador(inmobiliaria, (Comprador) usuarioLogueado);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Sistema Inmobiliario - Panel Comprador");
                    stage.show();

                    Stage loginStage = (Stage) btnIngreseLogging.getScene().getWindow();
                    loginStage.close();

                } else if (usuarioLogueado instanceof Vendedor) {
                    System.out.println("¡Bienvenido Vendedor!: " + usuarioLogueado.getNombre());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/inmobilaria/SistemaVendedores.fxml"));
                    Parent root = loader.load();

                    SistemaVendedoresController controller = loader.getController();
                    controller.setInmobiliariaYVendedor(inmobiliaria, (Vendedor) usuarioLogueado);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Sistema Inmobiliario - Panel Vendedor");
                    stage.show();
                    Stage loginStage = (Stage) btnIngreseLogging.getScene().getWindow();
                    loginStage.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                mostrarAlerta("Error Crítico", "No se pudo cargar la ventana. Revisa la consola.");
            }
        } else {
            mostrarAlerta("Error de Ingreso", "El usuario con identificación " + cedulaDigitada + " no está registrado.");
        }
    }

    @FXML
    void ActionRegistroW(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/inmobilaria/Registration.fxml"));
            Parent root = loader.load();

            RegistrationController controller = loader.getController();
            controller.setInmobiliaria(this.inmobiliaria);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Usuario buscarUsuarioPorCedula(String identificacion) {
        if (inmobiliaria.getListausuario() == null) {
            return null;
        }
        for (Usuario usuario : inmobiliaria.getListausuario()) {
            if (usuario.getIdentificacion().equals(identificacion)) {
                return usuario;
            }
        }
        return null;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML void EventKeyContraseñaW1(KeyEvent event) {}
    @FXML void EventKeyUsuarioW1(KeyEvent event) {}
}