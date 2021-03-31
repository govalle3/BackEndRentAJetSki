package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioRentAJetSki {


    /**
     * Permite crear un alquiler
     * @param alquiler
     */
    void crearAlquiler(Alquiler alquiler);

    /**
     * Permite actualizar el pago de un alquiler
     * @param alquiler
     *
     */
    void pagarAlquiler(Alquiler alquiler);

    /**
     * Permite crear un usuario
     * @param usuario
     *
     */
    void crearUsuario(Usuario usuario);
}
