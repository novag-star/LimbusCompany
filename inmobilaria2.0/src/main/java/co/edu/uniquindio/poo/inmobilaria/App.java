package co.edu.uniquindio.poo.inmobilaria;

import co.edu.uniquindio.poo.inmobilaria.controller.LoggingController;
import co.edu.uniquindio.poo.inmobilaria.model.Inmobilaria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {


    private final Inmobilaria inmobiliaria = new Inmobilaria("Uniquindio Inmobiliaria");

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/inmobilaria/Logging.fxml"));
            Parent root = loader.load();


            LoggingController controller = loader.getController();
            if (controller != null) {
                controller.setInmobiliaria(this.inmobiliaria);
            }


            Scene scene = new Scene(root);
            primaryStage.setTitle("Inmobiliaria - Iniciar Sesión");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}