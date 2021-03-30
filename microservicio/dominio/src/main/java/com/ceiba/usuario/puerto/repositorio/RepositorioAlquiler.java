package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Alquiler;

public interface RepositorioAlquiler {


    /**
     * Permite crear un alquiler
     * @param alquiler
     * @return true para saber que fue creado
     */
    boolean crearAlquiler(Alquiler alquiler);

    /**
     * Permite actualizar el pago de un alquiler
     * @param alquiler
     *
     */
    void actualizarEstadoPagadoAlquiler(Alquiler alquiler);

}
