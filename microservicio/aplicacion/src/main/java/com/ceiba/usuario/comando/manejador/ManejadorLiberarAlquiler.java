package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.servicio.ServicioLiberarAlquiler;

public class ManejadorLiberarAlquiler {

    private final ServicioLiberarAlquiler servicioLiberarAlquiler;
    private final FabricaAlquiler fabricaAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ManejadorLiberarAlquiler(ServicioLiberarAlquiler servicioLiberarAlquiler, FabricaAlquiler fabricaAlquiler, DaoAlquiler daoAlquiler) {
        this.servicioLiberarAlquiler = servicioLiberarAlquiler;
        this.fabricaAlquiler = fabricaAlquiler;
        this.daoAlquiler = daoAlquiler;
    }


    public void actualizar(Long nationalId) {
        DtoAlquiler dtoAlquiler = daoAlquiler.buscarAlquilerNoPagadoAun(nationalId);
        Alquiler alquiler = this.fabricaAlquiler.crear(dtoAlquiler);
        servicioLiberarAlquiler.actualizarEstadoPagadoAlquiler(alquiler);

    }}
