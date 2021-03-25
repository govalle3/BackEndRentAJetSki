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
        name = "German";
        LocalDate localDate = LocalDate.of(1990, Month.FEBRUARY, 25);//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedString = localDate.format(formatter);
        dob = LocalDate.parse(formattedString);
        idJetSki = "BC002";
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

    public ComandoAlquilerTestDataBuilder conDob(LocalDate dob) {
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
