/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Usuarios;

import Model.DAO.Dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import DataBase.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 9567
 */
public class UsuariosDAO extends Dao<UsuariosDTO>{

    public UsuariosDAO(Connection connection) {
        super(DataBase.getInstance().getConnection());
    }

    @Override
    public boolean create(UsuariosDTO dto) throws SQLException {
        String sql = "INSERT INTO Usuario (user_name, password, rol) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dto.getUser_name());
            ps.setString(2, dto.getPassword());
            ps.setInt(3, dto.getRol());
            return ps.executeUpdate()>0;
        }
    }

    @Override
    public UsuariosDTO read(Object id) throws SQLException {
        String query = "SELECT * FROM Usuario WHERE user_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, (String) id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UsuariosDTO(
                        rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getString("password"),
                        rs.getInt("rol")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<UsuariosDTO> readAll() throws SQLException {
         List<UsuariosDTO> usuarios = new ArrayList<>();
        String query = "SELECT * FROM Usuario";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new UsuariosDTO(
                    rs.getInt("id"),
                    rs.getString("user_name"),
                    rs.getString("password"),
                    rs.getInt("rol")
                ));
            }
        }
        return usuarios;
    }

    @Override
    public boolean update(UsuariosDTO dto) throws SQLException {
        String query = "UPDATE Usuario SET password = ?, rol = ? WHERE user_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getPassword());
            stmt.setInt(2, dto.getRol());
            stmt.setString(3, dto.getUser_name());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        String query = "DELETE FROM Usuario WHERE user_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, (String) id);
            return stmt.executeUpdate() > 0;
        }
    }

}
