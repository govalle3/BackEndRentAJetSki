package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.dtoComando.ComandoUsuarioAlquiler;
import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;

public class ManejadorCrearAlquilerUsuarioNuevo implements ManejadorComandoRespuesta<ComandoUsuarioAlquiler, ComandoRespuesta<Long>> {

    private final ServicioCrearUsuario servicioCrearUsuario;
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final FabricaAlquiler fabricaAlquiler;
    private final FabricaUsuario fabricaUsuario;

    public ManejadorCrearAlquilerUsuarioNuevo(FabricaAlquiler fabricaAlquiler, ServicioCrearUsuario servicioCrearUsuario, ServicioCrearAlquiler servicioCrearAlquiler, FabricaUsuario fabricaUsuario) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
        this.servicioCrearAlquiler = servicioCrearAlquiler;

    }

    public ComandoRespuesta<Long> ejecutar(ComandoUsuarioAlquiler comandoUsuarioAlquiler) { // Estos datos vienen del frontEnd
        Alquiler alquiler = this.fabricaAlquiler.crearAlquilerUsuarioRegistrado(comandoUsuarioAlquiler);
        Usuario usuario = this.fabricaUsuario.crearUsuario(comandoUsuarioAlquiler);
        this.servicioCrearUsuario.crearUsuario(usuario);
        return new ComandoRespuesta<>(this.servicioCrearAlquiler.crearAlquiler(alquiler)); // aca explota
    }




}
