package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;

import java.util.List;

public interface DaoAlquiler {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoAlquiler> listar();

    /**
     * Permite validar si el usuario eligió minimo 10 minutos de alquiler
     * @param usuario
     * @return si eligió minimo 10 minutos o no
     */
    Alquiler buscarPornationalId(long nationalId);
}
