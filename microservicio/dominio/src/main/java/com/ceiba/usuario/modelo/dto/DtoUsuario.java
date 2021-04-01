package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private final Long cedula;
    private final String nombre;
    private final LocalDate fechaNacido;
}
