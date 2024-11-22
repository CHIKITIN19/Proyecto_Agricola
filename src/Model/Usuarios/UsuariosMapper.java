/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Usuarios;

import Model.Mapper.Mapper;

/**
 *
 * @author 9567
 */
public class UsuariosMapper implements Mapper<Usuarios, UsuariosDTO>{

    @Override
    public UsuariosDTO toDto(Usuarios ent) {
        if(ent==null){
            return null;
        }
        return new UsuariosDTO(
                ent.getId(), 
                ent.getUser_name(),
                ent.getPassword(), 
                ent.getRol()
        );
    }

    @Override
    public Usuarios toEntity(UsuariosDTO dto) {
        if(dto==null){
            return null;
        }
        return new Usuarios(
                dto.getId(),
                dto.getUser_name(), 
                dto.getPassword(),
                dto.getRol()
        );
    }
    
}
