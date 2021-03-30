package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

public class ServicioLiberarAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioLiberarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }


    public void actualizarEstadoPagadoAlquiler(Alquiler alquiler) {
        this.repositorioAlquiler.actualizarEstadoPagadoAlquiler(alquiler);
    }

}
