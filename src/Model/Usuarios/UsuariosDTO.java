/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Usuarios;

/**
 *
 * @author 9567
 */
public class UsuariosDTO {
    private int id;
    private String user_name;
    private String password;
    private String rol;

    public UsuariosDTO() {
    }

    public UsuariosDTO(int id, String user_name, String password, String rol) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

}
