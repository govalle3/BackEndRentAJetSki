package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioValidarExistenciaUsuarioYPagosAlDia;

import java.time.LocalDateTime;

public class ManejadorCrearAlquilerUsuarioRegistrado {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia;

    public ManejadorCrearAlquilerUsuarioRegistrado(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler, ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioValidarExistenciaUsuarioYPagosAlDia = servicioValidarExistenciaUsuarioYPagosAlDia;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }

    public void ejecutar(Long cedula, String idJetSki, Integer tiempoRentado, LocalDateTime horaYFechaRenta) {
        Alquiler alquiler = this.fabricaAlquiler.crearRegistroUsuarioExistente(cedula,idJetSki,tiempoRentado,horaYFechaRenta);
        this.servicioValidarExistenciaUsuarioYPagosAlDia.validarExistenciaUsuarioYPagosAlDia(alquiler);
        this.servicioCrearAlquiler.crearAlquiler(alquiler);
    }
}
