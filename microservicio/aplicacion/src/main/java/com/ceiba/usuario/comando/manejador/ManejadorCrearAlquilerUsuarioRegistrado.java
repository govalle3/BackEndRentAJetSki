package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;

import java.time.LocalDateTime;

public class ManejadorCrearAlquilerUsuarioRegistrado {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final DaoRentAJetSki daoRentAJetSki;

    public ManejadorCrearAlquilerUsuarioRegistrado(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler, DaoRentAJetSki daoRentAJetSki) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
        this.daoRentAJetSki = daoRentAJetSki;
    }
    public void ejecutar(Long cedula, String idJetSki, Integer tiempoRentado, LocalDateTime horaYFechaRenta) { // Estos datos vienen del frontEnd
        Alquiler alquiler = this.fabricaAlquiler.crearRegistroUsuarioExistente(cedula,idJetSki,tiempoRentado,horaYFechaRenta);
        if(daoRentAJetSki.existeUsuarioPorCedula(cedula)){
            if(daoRentAJetSki.estaAlDiaElUsuario(cedula)){
                this.servicioCrearAlquiler.crearAlquiler(alquiler);
            }
            // EL usuario debe aun alquileres
        }
        // Arrojar una excepción ?

    }



}
