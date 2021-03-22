package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;

import java.util.Map;

public class ManejadorPagarAlquiler  {

    private final ServicioPagarAlquiler servicioPagarAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ManejadorPagarAlquiler(ServicioPagarAlquiler servicioPagarAlquiler, DaoAlquiler daoAlquiler) {
        this.servicioPagarAlquiler = servicioPagarAlquiler;
        this.daoAlquiler = daoAlquiler;
    }

    public double ejecutar(Long nationalId) {
        DtoAlquiler dtoAlquiler = daoAlquiler.buscarPorNationalId(nationalId);
        return servicioPagarAlquiler.pagarAlquiler(dtoAlquiler);
    }
}
