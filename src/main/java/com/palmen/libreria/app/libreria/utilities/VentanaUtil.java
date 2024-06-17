package com.palmen.libreria.app.libreria.utilities;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

//Creo esta clase para centralizar la configuración propia para poder mover las ventanas y para las imágenes de cerrar y minimizar la app
public class VentanaUtil {
    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void configurarBotonesVentana(Stage stage, ImageView imgCerrar, ImageView imgMinimizar) {
        // Cargar las imágenes
        Image imgCerrarNormal = new Image(Objects.requireNonNull(VentanaUtil.class.getResource("/com/palmen/libreria/app/libreria/imgs/cerrar.png")).toString());
        Image imgCerrarHover = new Image(Objects.requireNonNull(VentanaUtil.class.getResource("/com/palmen/libreria/app/libreria/imgs/cerrarHover.png")).toString());
        Image imgMinimizarNormal = new Image(Objects.requireNonNull(VentanaUtil.class.getResource("/com/palmen/libreria/app/libreria/imgs/minimizar.png")).toString());
        Image imgMinimizarHover = new Image(Objects.requireNonNull(VentanaUtil.class.getResource("/com/palmen/libreria/app/libreria/imgs/minimizarHover.png")).toString());

        //Establecer las imágenes por defecto
        imgCerrar.setImage(imgCerrarNormal);
        imgMinimizar.setImage(imgMinimizarNormal);

        // Configurar acción para cerrar la ventana
        imgCerrar.setOnMouseClicked(event -> stage.close());

        // Configurar acción para minimizar la ventana
        imgMinimizar.setOnMouseClicked(event -> {
            stage.setIconified(true);
            imgMinimizar.setImage(imgMinimizarNormal);
        });

        // Cambiar cursor a mano al pasar sobre los botones
        imgCerrar.setOnMouseEntered(e -> {
            imgCerrar.setImage(imgCerrarHover);
            cambiarCursor(stage, Cursor.HAND);
        });

        imgCerrar.setOnMouseExited(e -> {
            imgCerrar.setImage(imgCerrarNormal);
            cambiarCursor(stage, Cursor.DEFAULT);
        });

        imgMinimizar.setOnMouseEntered(e -> {
            imgMinimizar.setImage(imgMinimizarHover);
            cambiarCursor(stage, Cursor.HAND);
        });

        imgMinimizar.setOnMouseExited(e -> {
            imgMinimizar.setImage(imgMinimizarNormal);
            cambiarCursor(stage, Cursor.DEFAULT);
        });
    }

    public static void hacerArrastrable(Stage stage, AnchorPane anchorPane) {
        anchorPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        anchorPane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    private static void cambiarCursor(Stage stage, Cursor cursor) {
        Scene scene = stage.getScene();
        scene.setCursor(cursor);
    }

}
