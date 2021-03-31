package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.dtoComando.ComandoUsuarioAlquiler;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;

import java.time.LocalDateTime;

@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler) { // viene del front end
        return new Alquiler(
                comandoAlquiler.getCedula(),
                comandoAlquiler.getIdJetSki(),
                comandoAlquiler.getTiempoRenta(),
                comandoAlquiler.getFechaYHoraRenta()
        );
    }

    public Alquiler crearAlquilerUsuarioRegistrado(ComandoUsuarioAlquiler comandoUsuarioAlquiler) { // viene del front end
        return new Alquiler(
                comandoUsuarioAlquiler.getCedula(),
                comandoUsuarioAlquiler.getIdJetSki(),
                comandoUsuarioAlquiler.getTiempoRenta(),
                comandoUsuarioAlquiler.getFechaYHoraRenta()
        );
    }

    public Alquiler crear(DtoAlquiler dtoAlquiler) { // viene de base de datos
        return new Alquiler(
                dtoAlquiler.getCedula(),
                dtoAlquiler.getIdJetSki(),
                dtoAlquiler.getTiempoRenta(),
                dtoAlquiler.getFechaYHoraRenta()
        );
    }

    public Alquiler crearRegistroUsuarioExistente(Long cedula, String idJetSki, Integer tiempoRenta, LocalDateTime fechaYHoraRenta) { // viene del fronts
        return new Alquiler(
                cedula,
                idJetSki,
                tiempoRenta,
                fechaYHoraRenta
        );
    }

}
