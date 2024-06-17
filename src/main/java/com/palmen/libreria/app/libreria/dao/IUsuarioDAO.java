package com.palmen.libreria.app.libreria.dao;

import java.sql.SQLException;

public interface IUsuarioDAO {
    boolean verificarCredenciales(String email, String contraseña);

    boolean registrarUsuario(String email, String nombre, String contraseña) throws SQLException;
}
