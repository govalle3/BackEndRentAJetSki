package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoRentAJetSki {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoAlquiler> listar();

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoAlquiler> listarPorPagar();

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoAlquiler> listarPagados();

    /**
     * Permite validar si el usuario eligió minimo 10 minutos de alquiler
     * @param nationalId
     * @return si existe un usuario registrado
     */
    DtoUsuario buscarUsuarioPorNationalId(Long nationalId);

    /**
     * Permite validar si el usuario eligió minimo 10 minutos de alquiler
     * @param nationalId
     * @return si existe un usuario registrado
     */
    DtoAlquiler buscarAlquilerPorNationalId(Long nationalId);

    /**
     * Permite validar si hay una moto alquilada
     * @param idJetSki
     * @return si existe una moto o no alquilada
     */
    boolean existeAlquilerMoto(String idJetSki);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param cedula
     * @return si existe o no
     */
    boolean existeUsuarioPorCedula(Long cedula);

    /**
     * Permite buscar un alquiler que aun no ha sido pagado
     * @param nationalId
     * @return un dto alquiler que aun no ha sido pagado
     */
    DtoAlquiler buscarAlquilerNoPagadoAun(Long nationalId);

    /**
     * Permite validar si el usuario eligió minimo 10 minutos de alquiler
     * @param nationalId
     * @return si existe un usuario registrado
     */
    DtoAlquiler buscarMontoPorNationalId(long nationalId);

    /**
     * Permite validar si el usuario eligió minimo 10 minutos de alquiler
     * @param cedula
     * @return si existe un usuario registrado
     */
    boolean estaAlDiaElUsuario(Long cedula);
}
