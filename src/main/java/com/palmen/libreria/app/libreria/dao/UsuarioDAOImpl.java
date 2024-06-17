package com.palmen.libreria.app.libreria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl implements IUsuarioDAO {

    private final Connection conn;

    public UsuarioDAOImpl(Connection conn) throws SQLException {
        this.conn = new ConexionBD().connection();
    }

    @Override
    public boolean verificarCredenciales(String email, String contraseña) {
        String consultarUsuario = "SELECT * FROM USUARIOS WHERE EMAIL = ? AND CONTRASEÑA = ?";

        try (PreparedStatement statement = conn.prepareStatement(consultarUsuario)) {
            statement.setString(1, email);
            statement.setString(2, contraseña);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Si se encuentra un registro, las credenciales son correctas
                    System.out.println("Usuario correcto");
                    return true;
                } else {
                    // Si no se encuentra ningún registro, las credenciales son incorrectas
                    System.out.println("Credenciales incorrectas");
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar las credenciales del usuario", e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean registrarUsuario(String email, String nombre, String contraseña) throws SQLException {
        PreparedStatement statement = null;
        try {
            // Construir la consulta SQL con placeholders (?)
            String createUserQuery = "INSERT INTO USUARIOS (email, nombre, contraseña) VALUES (?, ?, ?)";

            // Crear el PreparedStatement desde la conexión existente
            statement = conn.prepareStatement(createUserQuery);

            // Establecer los valores de los parámetros
            statement.setString(1, email);
            statement.setString(2, nombre);
            statement.setString(3, contraseña);

            int filasInsertada = statement.executeUpdate();
            return filasInsertada > 0;
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new SQLException("El email ya está registrado", e);
            } else {
                throw e;
            }
        } finally {
            // Cerrar el PreparedStatement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Manejar el error o lanzar una excepción
                    throw new RuntimeException("Error al cerrar el PreparedStatement", e);
                }
            }
            new ConexionBD().cerrarConexion(conn);
        }
    }
}
