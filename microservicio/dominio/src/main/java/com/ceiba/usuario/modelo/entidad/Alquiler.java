package com.ceiba.usuario.modelo.entidad;


import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

public class Alquiler {

    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
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

    public String getIdJetSki() {
        return idJetSki;
    }

    public Integer getTiempoRenta() {
        return tiempoRenta;
    }

    public LocalDateTime getFechaYHoraRenta() {
        return fechaYHoraRenta;
    }

}
