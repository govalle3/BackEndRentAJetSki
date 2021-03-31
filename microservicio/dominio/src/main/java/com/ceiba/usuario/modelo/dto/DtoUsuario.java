package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long cedula;
    private String nombre;
    private LocalDate fechaNacido;
}
