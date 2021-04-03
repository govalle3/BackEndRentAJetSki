package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;
import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioValidarExistenciaUsuarioYPagosAlDia;


public class ManejadorCrearAlquilerUsuarioRegistrado implements ManejadorComandoRespuesta<ComandoAlquiler, ComandoRespuesta<Long>> {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia;

    public ManejadorCrearAlquilerUsuarioRegistrado(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler, ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioValidarExistenciaUsuarioYPagosAlDia = servicioValidarExistenciaUsuarioYPagosAlDia;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoAlquiler comando) {
        Alquiler alquiler = this.fabricaAlquiler.crearRegistroUsuarioExistente(comando.getCedula(), comando.getIdJetSki(),comando.getTiempoRenta(), comando.getFechaYHoraRenta());
        this.servicioValidarExistenciaUsuarioYPagosAlDia.validarExistenciaUsuarioYPagosAlDia(alquiler);
        return new ComandoRespuesta<>(this.servicioCrearAlquiler.crearAlquiler(alquiler));
    }
}
