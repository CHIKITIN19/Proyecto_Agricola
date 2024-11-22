/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import Model.Trabajadores.TrabajadoresDAO;
import Model.Trabajadores.TrabajadoresDTO;
import Model.Usuarios.UsuariosDAO;
import Model.Usuarios.UsuariosDTO;
import java.sql.SQLException;
import DataBase.DataBase;
import java.sql.Connection;

/**
 *
 * @author 9567
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
    DataBase connection = DataBase.getInstance();
    TrabajadoresDAO trabajadoresDAO = new TrabajadoresDAO(connection.getConnection());
    UsuariosDAO usuariosDAO = new UsuariosDAO(connection.getConnection());

    try {
        // Registrar un trabajador
        TrabajadoresDTO nuevoTrabajador = new TrabajadoresDTO(
            "504111", "Jean", "22", "jean@example.com",
            "Trabajador", "Lunes a Viernes", 100.0
        );
        trabajadoresDAO.create(nuevoTrabajador);
        System.out.println("Trabajador registrado correctamente.");

        // Registrar un usuario manualmente
        UsuariosDTO nuevoUsuario = new UsuariosDTO("504", "123", 1);
        usuariosDAO.create(nuevoUsuario);
        System.out.println("Usuario asociado registrado correctamente.");

        // Leer el usuario
        UsuariosDTO usuario = usuariosDAO.read("504");
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getUser_name() +
                ", Rol: " + (usuario.getRol() == 0 ? "Administrador" : "Trabajador"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
}
