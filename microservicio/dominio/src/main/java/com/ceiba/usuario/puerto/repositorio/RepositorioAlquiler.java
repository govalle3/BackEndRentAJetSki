package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Alquiler;

public interface RepositorioAlquiler {
    /**
     * Permite validar si existe un usuario con un nombre
     * @param nationalId
     * @return si existe o no
     */
    boolean existe(Long nationalId);

    /**
     * Permite validar si el alquiler eligió minimo 10 minutos de alquiler
     * @param alquiler
     * @return si eligió minimo 10 minutos o no
     */
    boolean crearAlquiler(Alquiler alquiler);


}
