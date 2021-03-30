package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;

import java.time.LocalDateTime;

public class ManejadorCrearAlquiler {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ManejadorCrearAlquiler(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler, DaoAlquiler daoAlquiler) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
        this.daoAlquiler = daoAlquiler;
    }
    public void ejecutar(Long nationalId, String idJetSki, Integer rentTime, LocalDateTime dateAndTimeRent) { // Estos datos vienen del frontEnd
        DtoAlquiler dtoAlquiler = daoAlquiler.buscarPorNationalId(nationalId);
        Alquiler alquiler = this.fabricaAlquiler.crearRegistroExistente(dtoAlquiler, idJetSki, rentTime, dateAndTimeRent);
        this.servicioCrearAlquiler.crearAlquiler(alquiler);
    }



}
