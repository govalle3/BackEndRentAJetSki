package com.ceiba.usuario.comando;

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

    private Long nationalId;
    private String name;
    private LocalDateTime dob;
    private String idJetSki;
    private Integer rentTime;
    private LocalDateTime dateAndTimeRent;
}
