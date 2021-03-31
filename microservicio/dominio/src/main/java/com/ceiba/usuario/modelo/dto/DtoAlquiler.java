package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private Long cedula;
    private String idJetSki;
    private Integer tiempoRenta;
    private LocalDateTime fechaYHoraRenta;
}
