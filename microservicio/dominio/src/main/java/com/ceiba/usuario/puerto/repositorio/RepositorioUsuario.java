package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {
    /**
     * Permite crear un usuario
     * @param usuario
     * @return el id generado
     */
    Long crear(Usuario usuario);

    /**
     * Permite actualizar un usuario
     * @param usuario
     */
    void actualizar(Usuario usuario);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nationalId
     * @return si existe o no
     */
    boolean existe(Long nationalId);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nationalId
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long nationalId, String name);

}
