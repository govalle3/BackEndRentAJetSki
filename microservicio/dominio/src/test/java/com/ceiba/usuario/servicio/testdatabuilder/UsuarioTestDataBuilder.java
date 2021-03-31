package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;
import java.time.Month;

public class UsuarioTestDataBuilder {

    private Long cedula;
    private String nombre;
    private LocalDate fechaNacido;

    public UsuarioTestDataBuilder() {
        cedula = 1098682980L;
        nombre = "German";
        fechaNacido = LocalDate.of(1990, Month.FEBRUARY,26);

    }

    public UsuarioTestDataBuilder conCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conFechaNacido(LocalDate fechaNacido) {
        this.fechaNacido = fechaNacido;
        return this;
    }

    public Usuario build() {
        return new Usuario(cedula, nombre, fechaNacido);
    }
}
