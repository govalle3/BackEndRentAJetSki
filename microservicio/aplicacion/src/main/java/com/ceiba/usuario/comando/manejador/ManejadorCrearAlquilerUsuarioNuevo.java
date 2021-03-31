package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.comando.dtoComando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;

public class ManejadorCrearAlquilerUsuarioNuevo {

    private final ServicioCrearUsuario servicioCrearUsuario;
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final FabricaAlquiler fabricaAlquiler;
    private final FabricaUsuario fabricaUsuario;

    public ManejadorCrearAlquilerUsuarioNuevo(FabricaAlquiler fabricaAlquiler, ServicioCrearUsuario servicioCrearUsuario, ServicioCrearAlquiler servicioCrearAlquiler, FabricaUsuario fabricaUsuario) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioCrearUsuario = servicioCrearUsuario;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
        this.fabricaUsuario = fabricaUsuario;
    }

    public void ejecutar(ComandoAlquiler comandoAlquiler, ComandoUsuario comandoUsuario) { // Estos datos vienen del frontEnd
        Alquiler alquiler = this.fabricaAlquiler.crear(comandoAlquiler);
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        this.servicioCrearUsuario.crearUsuario(usuario);
        this.servicioCrearAlquiler.crearAlquiler(alquiler);
    }


}
