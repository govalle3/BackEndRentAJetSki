package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;

public class ManejadorCrearAlquiler {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCrearAlquiler servicioCrearAlquiler;

    public ManejadorCrearAlquiler(FabricaUsuario fabricaUsuario, ServicioCrearAlquiler servicioCrearAlquiler) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }



}
