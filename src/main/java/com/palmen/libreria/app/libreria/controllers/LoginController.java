package com.palmen.libreria.app.libreria.controllers;

import com.palmen.libreria.app.libreria.dao.ConexionBD;
import com.palmen.libreria.app.libreria.dao.UsuarioDAOImpl;
import com.palmen.libreria.app.libreria.utilities.VentanaUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

    @FXML
    private Label lblErrorLogin;

    private Stage stage;

    private double xOffset = 0;

    private double yOffset = 0;

    public void initialize() {
        haciaRegistro();
        loginCorrecto();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        VentanaUtil.configurarBotonesVentana(stage, imgCerrarAplicacion, imgMinimizarAplicacion);
        VentanaUtil.hacerArrastrable(stage, anchorPane);
    }

    public void haciaRegistro() {
        lblClickAqui.setOnMouseClicked(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/palmen/libreria/app/libreria/controllers/RegistroView.fxml"));
                Scene scene = new Scene(loader.load());

                RegistroController registroController = loader.getController();
                Stage registroStage = new Stage();
                registroStage.setTitle("Login");
                registroStage.setResizable(false);
                registroStage.initStyle(StageStyle.UNDECORATED);
                registroStage.setScene(scene);
                registroController.setStage(registroStage);

                registroStage.show();

                // Cerrar la ventana actual
                stage.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void haciaLibreriaMain() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/palmen/libreria/app/libreria/controllers/LibreriaMainView.fxml"));
            Scene scene = new Scene(loader.load());

            LibreriaMainController libreriaMainController = loader.getController();
            Stage libreriaStage = new Stage();
            libreriaStage.setTitle("Libreria");
            libreriaStage.setResizable(false);
            libreriaStage.initStyle(StageStyle.UNDECORATED);
            libreriaStage.setScene(scene);
            libreriaMainController.setStage(libreriaStage);

            libreriaStage.show();

            // Cerrar la ventana actual
            stage.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loginCorrecto() {
        btnEntrar.setOnMouseClicked(e -> {
            try {
                // Crear la conexión a la base de datos
                ConexionBD conexionBD = new ConexionBD();
                Connection conn = conexionBD.connection();

                // Crear el DAO y registrar el usuario
                UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(conn);
                if (usuarioDAO.verificarCredenciales(txtEmail.getText(), txtContraseña.getText())) {
                    haciaLibreriaMain();
                }else{
                    lblErrorLogin.setText("El email o la contraseña son incorrectos");
                }

                // Cerrar la conexión
                conexionBD.cerrarConexion(conn);
            } catch (SQLException ex) {
                throw new RuntimeException("Error al registrar usuario en la base de datos", ex);
            }
        });
    }
}
