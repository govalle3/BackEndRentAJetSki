package com.ceiba.usuario.modelo.entidad;


import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;

public class Alquiler {

    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cédula";
    private static final String SE_DEBE_SELECCIONAR_UNA_MOTO_ACUATICA = "Se debe seleccionar una moto acuática";
    private static final String SE_DEBE_SELECCIONAR_TIEMPO_DE_ALQUILER = "Se debe seleccionar el tiempo de alquiler";
    private static final String NO_SE_PERMITEN_NUMEROS_NEGATIVOS = "No se permiten números negativos";

    private static final String SOLO_SE_PERMITEN_CARACTERES_NUMERICOS = "Solo se permiten caracteres numéricos";

    private Long cedula;
    private String idJetSki;
    private Integer tiempoRenta;
    private LocalDateTime fechaYHoraRenta;

    public Alquiler(Long cedula, String idJetSki, Integer tiempoRenta, LocalDateTime fechaYHoraRenta) {

        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(idJetSki, SE_DEBE_SELECCIONAR_UNA_MOTO_ACUATICA);
        validarObligatorio(tiempoRenta, SE_DEBE_SELECCIONAR_TIEMPO_DE_ALQUILER);
        validarPositivo(cedula.doubleValue(), NO_SE_PERMITEN_NUMEROS_NEGATIVOS);
        validarPositivo(tiempoRenta.doubleValue(), NO_SE_PERMITEN_NUMEROS_NEGATIVOS);
        validarNumerico(cedula.toString(),SOLO_SE_PERMITEN_CARACTERES_NUMERICOS);
        validarNumerico(tiempoRenta.toString(),SOLO_SE_PERMITEN_CARACTERES_NUMERICOS);

        this.cedula = cedula;
        this.idJetSki = idJetSki;
        this.tiempoRenta = tiempoRenta;
        this.fechaYHoraRenta = fechaYHoraRenta;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getIdJetSki() {
        return idJetSki;
    }

    public void setIdJetSki(String idJetSki) {
        this.idJetSki = idJetSki;
    }

    public Integer getTiempoRenta() {
        return tiempoRenta;
    }

    public void setTiempoRenta(Integer tiempoRenta) {
        this.tiempoRenta = tiempoRenta;
    }

    public LocalDateTime getFechaYHoraRenta() {
        return fechaYHoraRenta;
    }

    public void setFechaYHoraRenta(LocalDateTime fechaYHoraRenta) {
        this.fechaYHoraRenta = fechaYHoraRenta;
    }
}
