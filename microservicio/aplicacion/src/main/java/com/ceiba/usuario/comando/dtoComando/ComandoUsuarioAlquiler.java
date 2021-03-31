package com.ceiba.usuario.comando.dtoComando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuarioAlquiler {

    private Long cedula;
    private String nombre;
    private LocalDate fechaNacido;
    private String idJetSki;
    private Integer tiempoRenta;
    private LocalDateTime fechaYHoraRenta;
}
