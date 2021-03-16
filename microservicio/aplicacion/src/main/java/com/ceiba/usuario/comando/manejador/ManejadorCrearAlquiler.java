package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;

public class ManejadorCrearAlquiler implements ManejadorComando<ComandoUsuario> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCrearAlquiler servicioCrearAlquiler;

    public ManejadorCrearAlquiler(FabricaUsuario fabricaUsuario, ServicioCrearAlquiler servicioCrearAlquiler) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }
    public void ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        this.servicioCrearAlquiler.crearAlquiler(usuario);
    }


}
