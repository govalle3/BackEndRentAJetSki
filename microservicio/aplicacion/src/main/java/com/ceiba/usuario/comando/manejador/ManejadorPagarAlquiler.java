package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;

public class ManejadorPagarAlquiler {

    private final ServicioPagarAlquiler servicioPagarAlquiler;
    private final FabricaAlquiler fabricaAlquiler;
    private final DaoRentAJetSki daoRentAJetSki;

    public ManejadorPagarAlquiler(ServicioPagarAlquiler servicioPagarAlquiler, FabricaAlquiler fabricaAlquiler, DaoRentAJetSki daoRentAJetSki) {

        this.daoRentAJetSki = daoRentAJetSki;
        this.servicioPagarAlquiler = servicioPagarAlquiler;
        this.fabricaAlquiler = fabricaAlquiler;
    }

    public void pagar(Long nationalId) {
        DtoAlquiler dtoAlquiler = daoRentAJetSki.buscarAlquilerNoPagadoAun(nationalId);
        Alquiler alquiler = this.fabricaAlquiler.crear(dtoAlquiler);
        servicioPagarAlquiler.pagarAlquiler(alquiler);
    }
}
