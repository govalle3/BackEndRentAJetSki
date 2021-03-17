package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;

public class ManejadorPagarAlquiler  {

    private final ServicioPagarAlquiler servicioPagarAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ManejadorPagarAlquiler(ServicioPagarAlquiler servicioPagarAlquiler, DaoAlquiler daoAlquiler) {
        this.servicioPagarAlquiler = servicioPagarAlquiler;
        this.daoAlquiler = daoAlquiler;
    }

    public double ejecutar(Long nationalId) {
        Alquiler alquiler = daoAlquiler.buscarPornationalId(nationalId);
        return servicioPagarAlquiler.pagarAlquiler(alquiler);
    }
}
