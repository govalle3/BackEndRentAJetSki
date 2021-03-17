package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.util.List;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoUsuario> listar();

    /**
     * Permite validar si el usuario eligió minimo 10 minutos de alquiler
     * @param usuario
     * @return si eligió minimo 10 minutos o no
     */
    Usuario buscarPornationalId(long nationalId);
}
