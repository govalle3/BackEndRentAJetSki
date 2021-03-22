package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoAlquiler;

@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler) { // viene del front end el comando
        return new Alquiler(
                comandoAlquiler.getNationalId(),
                comandoAlquiler.getName(),
                comandoAlquiler.getDob(),
                comandoAlquiler.getIdJetSki(),
                comandoAlquiler.getRentTime(),
                comandoAlquiler.getDateAndTimeRent()
        );
    }

    public Alquiler crear(DtoAlquiler dtoAlquiler) { // viene de base de datos
        return new Alquiler(
                dtoAlquiler.getNationalId(),
                dtoAlquiler.getName(),
                dtoAlquiler.getDob(),
                dtoAlquiler.getIdJetSki(),
                dtoAlquiler.getRentTime(),
                dtoAlquiler.getDateAndTimeRent()
        );
    }

}
