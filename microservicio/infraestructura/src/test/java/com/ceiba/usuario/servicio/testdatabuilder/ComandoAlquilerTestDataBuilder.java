package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.dtoComando.ComandoAlquiler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class ComandoAlquilerTestDataBuilder {

    private Long nationalId;
    private String name;
    private LocalDate dob;
    private String idJetSki;
    private Integer rentTime;
    private LocalDateTime dateAndTimeRent;

    public ComandoAlquilerTestDataBuilder() {
        nationalId = 1234L;
        idJetSki = "BC002";
        rentTime = 15;
        dateAndTimeRent = LocalDateTime.now();
    }

    public ComandoAlquilerTestDataBuilder conNationalId(Long nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conIdJetSki(String idJetSki) {
        this.idJetSki = idJetSki;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conRentTime(Integer rentTime) {
        this.rentTime = rentTime;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conDateAndTimeRent(LocalDateTime dateAndTimeRent) {
        this.dateAndTimeRent = dateAndTimeRent;
        return this;
    }

    public ComandoAlquiler build() {
        return new ComandoAlquiler(nationalId,idJetSki,rentTime,dateAndTimeRent);
    }
}
