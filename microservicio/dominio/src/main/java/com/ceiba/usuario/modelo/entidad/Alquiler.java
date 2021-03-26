package com.ceiba.usuario.modelo.entidad;


import java.time.LocalDate;
import java.time.LocalDateTime;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class Alquiler {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cédula";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";
    private static final String SE_DEBE_SELECCIONAR_UNA_MOTO_ACUATICA = "Se debe seleccionar una moto acuatica";
    private static final String SE_DEBE_SELECCIONAR_TIEMPO_DE_ALQUILER = "Se debe seleccionar el tiempo de alquiler";

    private Long nationalId;
    private String name;
    private LocalDate dob;
    private String idJetSki;
    private Integer rentTime;
    private LocalDateTime dateAndTimeRent;

    public Alquiler(Long nationalId, String name, LocalDate dob, String idJetSki, Integer rentTime, LocalDateTime dateAndTimeRent) {

        validarObligatorio(nationalId, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(name, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(dob, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
        validarObligatorio(idJetSki, SE_DEBE_SELECCIONAR_UNA_MOTO_ACUATICA);
        validarObligatorio(rentTime, SE_DEBE_SELECCIONAR_TIEMPO_DE_ALQUILER);

        this.nationalId = nationalId;
        this.name = name;
        this.dob = dob;
        this.idJetSki = idJetSki;
        this.rentTime = rentTime;
        this.dateAndTimeRent = dateAndTimeRent;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getIdJetSki() {
        return idJetSki;
    }

    public void setIdJetSki(String idJetSki) {
        this.idJetSki = idJetSki;
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public void setRentTime(Integer rentTime) {
        this.rentTime = rentTime;
    }

    public LocalDateTime getDateAndTimeRent() {
        return dateAndTimeRent;
    }

    public void setDateAndTimeRent(LocalDateTime dateAndTimeRent) {
        this.dateAndTimeRent = dateAndTimeRent;
    }
}
