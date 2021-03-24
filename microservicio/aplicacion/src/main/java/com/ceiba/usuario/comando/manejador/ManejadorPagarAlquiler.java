package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;

import java.time.LocalDateTime;

public class ManejadorPagarAlquiler  {

    private final ServicioPagarAlquiler servicioPagarAlquiler;
    private final FabricaAlquiler fabricaAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ManejadorPagarAlquiler(ServicioPagarAlquiler servicioPagarAlquiler, FabricaAlquiler fabricaAlquiler, DaoAlquiler daoAlquiler) {
        this.servicioPagarAlquiler = servicioPagarAlquiler;
        this.fabricaAlquiler = fabricaAlquiler;
        this.daoAlquiler = daoAlquiler;
    }

    public double ejecutar(long nationalId, LocalDateTime dateAndTimeCheckout) {

        DtoAlquiler dtoAlquiler = daoAlquiler.buscarPorNationalId(nationalId);
        Alquiler alquiler = this.fabricaAlquiler.crear(dtoAlquiler);
        return servicioPagarAlquiler.pagarAlquiler(alquiler, dateAndTimeCheckout);
        
    }
}
