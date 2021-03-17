package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoAlquiler;

import java.time.LocalDateTime;
import java.time.Month;

public class ComandoAlquilerTestDataBuilder {

    private Long nationalId;
    private String name;
    private LocalDateTime dob;
    private String idJetSki;
    private Integer rentTime;
    private LocalDateTime dateAndTimeRent;

    public ComandoAlquilerTestDataBuilder() {
        nationalId = 51658654L;
        name = "1234";
        dob = LocalDateTime.of(1990, Month.FEBRUARY, 26, 19, 30, 40);
        idJetSki = "BC01";
        rentTime = 15;
        dateAndTimeRent = LocalDateTime.now();
    }

    public ComandoAlquilerTestDataBuilder conNationalId(Long nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conName(String name) {
        this.name = name;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conDob(LocalDateTime dob) {
        this.dob = dob;
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
        return new ComandoAlquiler(nationalId,name,dob,idJetSki,rentTime,dateAndTimeRent);
    }
}
