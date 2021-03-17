package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoAlquiler;

@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler) {
        return new Alquiler(
                comandoAlquiler.getNationalId(),
                comandoAlquiler.getName(),
                comandoAlquiler.getDob(),
                comandoAlquiler.getIdJetSki(),
                comandoAlquiler.getRentTime(),
                comandoAlquiler.getDateAndTimeRent()
        );
    }

}
