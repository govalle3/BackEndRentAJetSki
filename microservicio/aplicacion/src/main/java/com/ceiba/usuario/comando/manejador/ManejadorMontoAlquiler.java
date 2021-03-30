package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.servicio.ServicioMontoAlquiler;

import java.time.LocalDateTime;

public class ManejadorMontoAlquiler {

    private final ServicioMontoAlquiler servicioMontoAlquiler;
    private final FabricaAlquiler fabricaAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ManejadorMontoAlquiler(ServicioMontoAlquiler servicioMontoAlquiler, FabricaAlquiler fabricaAlquiler, DaoAlquiler daoAlquiler) {
        this.servicioMontoAlquiler = servicioMontoAlquiler;
        this.fabricaAlquiler = fabricaAlquiler;
        this.daoAlquiler = daoAlquiler;
    }

    public double ejecutar(long nationalId, LocalDateTime dateAndTimeCheckout) {

        DtoAlquiler dtoAlquiler = daoAlquiler.buscarMontoPorNationalId(nationalId);
        Alquiler alquiler = this.fabricaAlquiler.crear(dtoAlquiler);
        return servicioMontoAlquiler.pagarAlquiler(alquiler, dateAndTimeCheckout);
        
    }

}
