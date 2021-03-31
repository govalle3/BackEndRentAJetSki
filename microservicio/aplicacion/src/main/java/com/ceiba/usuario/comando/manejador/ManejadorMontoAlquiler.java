package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.servicio.ServicioCalcularMontoAlquiler;

import java.time.LocalDateTime;

public class ManejadorMontoAlquiler {

    private final ServicioCalcularMontoAlquiler servicioCalcularMontoAlquiler;
    private final FabricaAlquiler fabricaAlquiler;
    private final DaoRentAJetSki daoRentAJetSki;

    public ManejadorMontoAlquiler(ServicioCalcularMontoAlquiler servicioCalcularMontoAlquiler, FabricaAlquiler fabricaAlquiler, DaoRentAJetSki daoRentAJetSki) {
        this.servicioCalcularMontoAlquiler = servicioCalcularMontoAlquiler;
        this.fabricaAlquiler = fabricaAlquiler;
        this.daoRentAJetSki = daoRentAJetSki;
    }

    public double ejecutar(long cedula, LocalDateTime horaYFechaEntrega) {
        DtoAlquiler dtoAlquiler = daoRentAJetSki.buscarMontoPorNationalId(cedula);
        Alquiler alquiler = this.fabricaAlquiler.crear(dtoAlquiler);
        return servicioCalcularMontoAlquiler.calcularMontoAlquiler(alquiler, horaYFechaEntrega);
        
    }

}
