package com.ceiba.usuario.comando.dtoComando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAlquiler {

    private Long cedula;
    private String idJetSki;
    private Integer tiempoRenta;
    private LocalDateTime fechaYHoraRenta;
}
