package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Alquiler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class AlquilerTestDataBuilder {

    private Long nationalId;
    private String name;
    private LocalDate dob;
    private String idJetSki;
    private Integer rentTime;
    private LocalDateTime dateAndTimeRent;

    public AlquilerTestDataBuilder() {
        nationalId = 109868280L;
        name = "german";
        dob = LocalDate.of(1990, Month.FEBRUARY,26);
        idJetSki = "BC01";
        rentTime = 15;
        dateAndTimeRent = LocalDateTime.now();
    }

    public AlquilerTestDataBuilder conNationalId(Long nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public AlquilerTestDataBuilder conName(String name) {
        this.name = name;
        return this;
    }

    public AlquilerTestDataBuilder conDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public AlquilerTestDataBuilder conIdJetSki(String idJetSki) {
        this.idJetSki = idJetSki;
        return this;
    }

    public AlquilerTestDataBuilder conRentTime(Integer rentTime) {
        this.rentTime = rentTime;
        return this;
    }

    public AlquilerTestDataBuilder conDateAndTimeRent(LocalDateTime dateAndTimeRent) {
        this.dateAndTimeRent = dateAndTimeRent;
        return this;
    }

    public Alquiler build() {
        return new Alquiler(nationalId,name, dob,idJetSki,rentTime,dateAndTimeRent);
    }
}
