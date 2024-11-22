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
        Connection connection = null;
        try {
            // Obtener la conexión desde la clase DataBase
            connection = DataBase.getInstance().getConnection();  // Obtienes la conexión

            // Crear instancias de los DAOs con la conexión
            TrabajadoresDAO trabajadoresDAO = new TrabajadoresDAO(connection);
            UsuariosDAO usuarioDAO = new UsuariosDAO(connection);

            // Crear un trabajador
            TrabajadoresDTO nuevoTrabajador = new TrabajadoresDTO(
                "0011223344", "Juan Pérez", "12345678", "juan.perez@example.com",
                "Supervisor", "Lunes a Viernes", 35000.00
            );
            trabajadoresDAO.create(nuevoTrabajador);
            System.out.println("Trabajador registrado. Usuario creado automáticamente.");

            // Leer el usuario asociado al trabajador
            UsuariosDTO usuario = usuarioDAO.read("0011223344");
            if (usuario != null) {
                System.out.println("Usuario encontrado: " + usuario.getUser_name() + ", Rol: " + usuario.getRol());
            } else {
                System.out.println("Usuario no encontrado.");
            }

            // Actualizar la contraseña si es necesario
            //usuario.setPassword("456");
            //usuarioDAO.update(usuario);
            //System.out.println("Contraseña actualizada.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
    // Cerrar la conexión a la base de datos al final
    if (connection != null) {
        connection.close();  // Cerrar la conexión después de la operación
    }
        }
    }
    
}
