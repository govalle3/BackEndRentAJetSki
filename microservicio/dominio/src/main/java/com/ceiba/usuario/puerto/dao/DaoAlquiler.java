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
     * @param nationalId
     * @return si existe un usuario registrado
     */
    Alquiler buscarPorNationalId(Long nationalId);

    /**
     * Permite validar si hay una moto alquilada
     * @param idJetSki
     * @return si existe una moto o no alquilada
     */
    boolean existeAlquilerMoto(String idJetSki);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nationalId
     * @return si existe o no
     */
    boolean existeUsuarioPorNationalId(Long nationalId);
}
