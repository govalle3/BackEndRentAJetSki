package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioCrearAlquiler {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    private static final String EL_USUARIO_YA_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER = "El usuario debe seleccionar minimo 10 minutos de alquiler";
    private static final String LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO = "Los dias miercoles no se presta servicio";
    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler){
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public void crearAlquiler(Alquiler alquiler) {
        validarMinimoDiezMinutos(alquiler.getRentTime());
        if(validWednesday()){
            throw new ExcepcionValorInvalido(LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO);
        }
        ejecutar(alquiler);
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

    public Boolean ejecutar(Alquiler alquiler) {
        validarExistenciaPrevia(alquiler);
        return this.repositorioAlquiler.crearAlquiler(alquiler);
    }

    private void validarExistenciaPrevia(Alquiler alquiler) {
        boolean existe = this.repositorioAlquiler.existe(alquiler.getNationalId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
