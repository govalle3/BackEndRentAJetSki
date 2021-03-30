package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;

public class ManejadorCrearUsuario {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioCrearUsuario servicioCrearUsuario;
    private final DaoAlquiler daoAlquiler;

    public ManejadorCrearUsuario(FabricaAlquiler fabricaAlquiler, ServicioCrearUsuario servicioCrearUsuario, DaoAlquiler daoAlquiler) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioCrearUsuario = servicioCrearUsuario;
        this.daoAlquiler = daoAlquiler;
    }

    public void registrar(ComandoAlquiler comandoAlquiler) { // Estos datos vienen del frontEnd
        Alquiler alquiler = this.fabricaAlquiler.crear(comandoAlquiler);
        this.servicioCrearUsuario.crearUsuario(alquiler);
    }
}
