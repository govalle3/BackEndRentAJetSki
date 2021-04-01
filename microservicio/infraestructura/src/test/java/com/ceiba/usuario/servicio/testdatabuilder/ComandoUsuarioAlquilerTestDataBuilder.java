package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.dtoComando.ComandoUsuarioAlquiler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class ComandoUsuarioAlquilerTestDataBuilder {

    private Long cedula;
    private String nombre;
    private LocalDate fechaNacido;
    private String idJetSki;
    private Integer tiempoRenta;
    private LocalDateTime fechaYHoraRenta;

    public ComandoUsuarioAlquilerTestDataBuilder() {
        cedula = 1234L;
        nombre = "Juan";
        fechaNacido = LocalDate.of(1990, Month.FEBRUARY,26);
        idJetSki = "BC003";
        tiempoRenta = 15;
        fechaYHoraRenta = LocalDateTime.now();
    }

    public ComandoUsuarioAlquilerTestDataBuilder conCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public ComandoUsuarioAlquilerTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuarioAlquilerTestDataBuilder conFechaNacido(LocalDate fechaNacido) {
        this.fechaNacido = fechaNacido;
        return this;
    }

    public ComandoUsuarioAlquilerTestDataBuilder conIdJetSki(String idJetSki) {
        this.idJetSki = idJetSki;
        return this;
    }

    public ComandoUsuarioAlquilerTestDataBuilder conTiempoRenta(Integer tiempoRenta) {
        this.tiempoRenta = tiempoRenta;
        return this;
    }

    public ComandoUsuarioAlquilerTestDataBuilder conFechaYHoraRenta(LocalDate fechaNacido) {
        this.fechaNacido = fechaNacido;
        return this;
    }


    public ComandoUsuarioAlquiler build() {
        return new ComandoUsuarioAlquiler(cedula,nombre,fechaNacido,idJetSki,tiempoRenta,fechaYHoraRenta);
    }
}
