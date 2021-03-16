package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long nationalId) {

        this.repositorioUsuario.eliminar(nationalId);
    }
}
