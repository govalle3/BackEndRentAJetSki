package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Alquiler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class AlquilerTestDataBuilder {

    private Long cedula;
    private String idJetSki;
    private Integer tiempoRenta;
    private LocalDateTime fechaYHoraRenta;

    public AlquilerTestDataBuilder() {
        cedula = 1098682980L;
        idJetSki = "BC001";
        tiempoRenta = 15;
        fechaYHoraRenta = LocalDateTime.now();
    }



    public AlquilerTestDataBuilder conIdJetSki(String idJetSki) {
        this.idJetSki = idJetSki;
        return this;
    }

    public AlquilerTestDataBuilder conTiempoRenta(Integer rentTime) {
        this.tiempoRenta = rentTime;
        return this;
    }

    public AlquilerTestDataBuilder conFechaYHoraRenta(LocalDateTime dateAndTimeRent) {
        this.fechaYHoraRenta = dateAndTimeRent;
        return this;
    }

    public Alquiler build() {
        return new Alquiler(cedula, idJetSki, tiempoRenta, fechaYHoraRenta);
    }
}
