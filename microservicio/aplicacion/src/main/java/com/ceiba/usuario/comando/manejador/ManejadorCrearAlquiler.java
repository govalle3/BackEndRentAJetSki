package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;

public class ManejadorCrearAlquiler implements ManejadorComando<ComandoAlquiler> {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioCrearAlquiler servicioCrearAlquiler;

    public ManejadorCrearAlquiler(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }
    public void ejecutar(ComandoAlquiler comandoAlquiler) {
        Alquiler alquiler = this.fabricaAlquiler.crear(comandoAlquiler);
        this.servicioCrearAlquiler.crearAlquiler(alquiler);
    }


}
