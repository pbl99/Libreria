package com.palmen.libreria.app.libreria.controllers;

import com.palmen.libreria.app.libreria.utilities.VentanaUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Label lblClickAqui;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtContraseña;

    @FXML
    private Button btnEntrar;

    @FXML
    private ImageView imgMinimizarAplicacion;

    @FXML
    private ImageView imgCerrarAplicacion;

    @FXML
    private AnchorPane anchorPane;

    private Stage stage;

    private double xOffset = 0;

    private double yOffset = 0;

    public void initialize() {
        obtenerDatos();
        setStage(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        VentanaUtil.configurarBotonesVentana(stage, imgCerrarAplicacion, imgMinimizarAplicacion);
        VentanaUtil.hacerArrastrable(stage, anchorPane);
    }

    private void obtenerDatos() {
        btnEntrar.setOnMouseClicked(e -> {
            if (txtEmail.getText() == "pabloam1999@hotmail.com" && txtContraseña.getText() == "INVIENRO") {
                System.out.println("El usuario conectado es el admin");
            } else {
                System.out.println("ERROR");
            }
        });
    }

    //Procedimiento para la lógica que afectará al movimiento de la aplicación y los labels que usaremos para minimizar y cerrar
   /* public void setStage(Stage stage) {
        this.stage = stage;

        // Inicializar los controladores de botones
        imgCerrarAplicacion.setOnMouseClicked(event -> stage.close());
        imgMinimizarAplicacion.setOnMouseClicked(event -> stage.setIconified(true));

        imgCerrarAplicacion.setOnMouseEntered(e -> {
            Scene scene = stage.getScene();
            scene.setCursor(Cursor.HAND);
        });
        imgCerrarAplicacion.setOnMouseExited(e -> {
            Scene scene = stage.getScene();
            scene.setCursor(Cursor.DEFAULT);
        });
        imgMinimizarAplicacion.setOnMouseEntered(e -> {
            Scene scene = stage.getScene();
            scene.setCursor(Cursor.HAND);
        });
        imgMinimizarAplicacion.setOnMouseExited(e -> {
            Scene scene = stage.getScene();
            scene.setCursor(Cursor.DEFAULT);
        });

        // Hacer que la ventana sea arrastrable
        anchorPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        anchorPane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }*/
}
