package com.palmen.libreria.app.libreria;

import com.palmen.libreria.app.libreria.controllers.LibreriaMainController;
import com.palmen.libreria.app.libreria.controllers.LoginController;
import com.palmen.libreria.app.libreria.controllers.RegistroController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Cargo tres fxml para poder ir probando las tres vistas independientes del Login del Registro y la Main
        // Cargar el FXML y su controlador para LibreriaMain
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/com/palmen/libreria/app/libreria/controllers/LibreriaMainView.fxml"));
        Parent mainRoot = mainLoader.load();
        LibreriaMainController mainController = mainLoader.getController();
        mainController.setStage(stage);

        // Cargar el FXML y su controlador para Login
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/com/palmen/libreria/app/libreria/controllers/LoginView.fxml"));
        Parent loginRoot = loginLoader.load();
        LoginController loginController = loginLoader.getController();
        loginController.setStage(stage);

        // Cargar el FXML y su controlador para Registro
        FXMLLoader registroLoader = new FXMLLoader(getClass().getResource("/com/palmen/libreria/app/libreria/controllers/RegistroView.fxml"));
        Parent registroRoot = registroLoader.load();
        RegistroController registroController = registroLoader.getController();
        registroController.setStage(stage);

        // Ejemplo de configuración de primaryStage con LibreriaMain
        stage.setTitle("Libreria");
        stage.setScene(new Scene(mainRoot));
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Mostrar la ventana principal
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}