package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioCrearAlquiler {

    private static final String EL_USUARIO_YA_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER = "El usuario debe seleccionar minimo 10 minutos de alquiler";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearAlquiler(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    public boolean crearAlquiler(Usuario usuario) {
        validarMinimoDiezMinutos(usuario.getRentTime());
        validWednesday();
        return this.repositorioUsuario.crearAlquiler(usuario);
    }

    private void validarMinimoDiezMinutos(Integer rentTime) {
        int eligio = rentTime;
        if(eligio < 10) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER);
        }
    }

    private Boolean validWednesday() {
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        return dayOfWeek.name().equals(DayOfWeek.WEDNESDAY.name());
    }

}
