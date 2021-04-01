package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private final Long cedula;
    private final String idJetSki;
    private final Integer tiempoRenta;
    private final LocalDateTime fechaYHoraRenta;
}
