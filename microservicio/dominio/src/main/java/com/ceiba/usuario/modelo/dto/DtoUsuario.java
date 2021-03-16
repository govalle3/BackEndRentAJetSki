package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long nationalId;
    private String name;
    private LocalDateTime dob;
    private String idJetSki;
    private Integer rentTime;
    private LocalDateTime dateAndTimeRent;
}
