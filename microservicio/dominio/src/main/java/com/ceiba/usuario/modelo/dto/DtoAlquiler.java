package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private Long nationalId;
    private String name;
    private LocalDate dob;
    private String idJetSki;
    private Integer rentTime;
    private LocalDateTime dateAndTimeRent;
}
