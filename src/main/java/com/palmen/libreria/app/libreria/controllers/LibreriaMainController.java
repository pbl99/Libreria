package com.palmen.libreria.app.libreria.controllers;

import com.palmen.libreria.app.libreria.utilities.VentanaUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LibreriaMainController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private StackPane contentPane;

    @FXML
    private Label lblInicio;

    @FXML
    private Label lblCategoria;

    @FXML
    private Label lblAudioLibro;

    @FXML
    private Label lblMiCuenta;

    @FXML
    private ImageView imgCerrarAplicacion;

    @FXML
    private ImageView imgMinimizarAplicacion;

    private Stage stage;

    @FXML
    public void initialize() {
        setStage(stage);
        try {
            showInicio();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        VentanaUtil.configurarBotonesVentana(stage, imgCerrarAplicacion, imgMinimizarAplicacion);
        VentanaUtil.hacerArrastrable(stage, anchorPane);
    }

    @FXML
    public void handleLabelClick(MouseEvent event) throws IOException {
        Label source = (Label) event.getSource();
        if (source == lblInicio) {
            showInicio();
        } else if (source == lblCategoria) {
            showCategorias();
        } else if (source == lblAudioLibro) {
            showAudiolibros();
        } else if (source == lblMiCuenta) {
            showMiCuenta();
        }
    }

    private void showInicio() throws IOException {
        loadView("InicioView.fxml");
    }

    private void showCategorias() throws IOException {
        loadView("CategoriasView.fxml");
    }

    private void showAudiolibros() throws IOException {
        loadView("AudioLibrosView.fxml");
    }

    private void showMiCuenta() throws IOException {
        loadView("MiCuentaView.fxml");
    }

    private void loadView(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        contentPane.getChildren().clear();
        contentPane.getChildren().add(root);
    }
}