package com.ceiba.usuario.modelo.entidad;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class Usuario {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cédula";
    private static final String LA_FECHA_INGRESADA_NO_ES_VALIDA = "La fecha ingresada no es valida";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";

    private Long cedula;
    private String nombre;
    private LocalDate fechaNacido;

    public Usuario(Long cedula, String nombre, LocalDate fechaNacido) {

        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(fechaNacido, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
        validarMenor(fechaNacido,LocalDate.now(),LA_FECHA_INGRESADA_NO_ES_VALIDA);

        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacido = fechaNacido;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacido() {
        return fechaNacido;
    }

    public void setFechaNacido(LocalDate fechaNacido) {
        this.fechaNacido = fechaNacido;
    }
}
