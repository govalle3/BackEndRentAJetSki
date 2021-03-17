package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cédula";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";


    private Long nationalId;
    private String name;
    private LocalDateTime dob;


    public Usuario(Long nationalId, String name, LocalDateTime dob) {

        validarObligatorio(name, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(nationalId, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(dob, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);

        this.nationalId = nationalId;
        this.name = name;
        this.dob = dob;
    }

}
