package com.palmen.libreria.app.libreria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3307/libreria";
    private static final String USUARIO = "palmenendez";
    private static final String CONTRASEÑA = "root";

    public Connection connection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
        }
        return conn;
    }

    // Método para cerrar la conexión
    public void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

