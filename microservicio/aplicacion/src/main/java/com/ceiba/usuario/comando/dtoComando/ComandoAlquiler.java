package com.ceiba.usuario.comando.dtoComando;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAlquiler {

    private Long nationalId;
    private String name;
    private LocalDate dob;
    private String idJetSki;
    private Integer rentTime;

    private LocalDateTime dateAndTimeRent;
}