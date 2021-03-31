package com.ceiba.usuario.comando.dtoComando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario {

    private Long cedula;
    private String nombre;
    private LocalDate fechaNacido;
}
