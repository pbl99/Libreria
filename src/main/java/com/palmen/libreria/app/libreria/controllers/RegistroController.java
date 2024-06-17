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

public class RegistroController {

    @FXML
    private Label lblClickAqui;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtContraseña;

    @FXML
    private Button btnRegistrarme;

    @FXML
    private ImageView imgMinimizarAplicacion;

    @FXML
    private ImageView imgCerrarAplicacion;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lblErrorEmail;

    @FXML
    private Label lblExitoRegistro;

    private Stage stage;

    private double xOffset = 0;

    private double yOffset = 0;

    public void initialize() {
        // Configurar botones de ventana y hacerla arrastrable
        haciaLogin();
        try {
            registrarUsuarios();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        VentanaUtil.configurarBotonesVentana(stage, imgCerrarAplicacion, imgMinimizarAplicacion);
        VentanaUtil.hacerArrastrable(stage, anchorPane);
    }

    public void haciaLogin() {
        lblClickAqui.setOnMouseClicked(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/palmen/libreria/app/libreria/controllers/LoginView.fxml"));
                Scene scene = new Scene(loader.load());

                LoginController loginController = loader.getController();
                Stage loginStage = new Stage();
                loginStage.setTitle("Login");
                loginStage.setResizable(false);
                loginStage.initStyle(StageStyle.UNDECORATED);
                loginStage.setScene(scene);
                loginController.setStage(loginStage);

                loginStage.show();

                // Cerrar la ventana actual
                stage.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void registrarUsuarios() throws SQLException {
        btnRegistrarme.setOnMouseClicked(e -> {
            try {
                // Crear la conexión a la base de datos
                ConexionBD conexionBD = new ConexionBD();
                Connection conn = conexionBD.connection();

                // Crear el DAO y registrar el usuario
                UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(conn);
                if (usuarioDAO.registrarUsuario(txtEmail.getText(), txtUsuario.getText(), txtContraseña.getText())) {
                    lblExitoRegistro.setText("El registro ha sido exitoso");
                }

                // Cerrar la conexión
                conexionBD.cerrarConexion(conn);
            } catch (SQLException ex) {
                if (ex.getMessage().contains("El email ya está registrado")) {
                    lblErrorEmail.setText("El email ya está registrado");
                }
            }
        });
    }
}

