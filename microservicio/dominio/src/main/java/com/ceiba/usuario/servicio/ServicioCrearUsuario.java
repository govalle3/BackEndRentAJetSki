package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class ServicioCrearUsuario {

    public static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    public static final String LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO = "Los dias miercoles no se presta servicio";
    public static final String SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD = "Solo se presta servicio a mayores de edad";
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final DaoAlquiler daoAlquiler;


    public ServicioCrearUsuario(ServicioCrearAlquiler servicioCrearAlquiler, DaoAlquiler daoAlquiler) {
        this.servicioCrearAlquiler = servicioCrearAlquiler;
        this.daoAlquiler = daoAlquiler;
    }

    public void crearUsuario(Alquiler alquiler){
        validWednesday();
        validarEdad(alquiler.getDob());
        validarExistenciaPrevia(alquiler);
        ejecutar(alquiler);

    }

    private void validWednesday() {
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        boolean result = dayOfWeek.name().equals(DayOfWeek.WEDNESDAY.name());
        if(result){
            throw new ExcepcionValorInvalido(LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO);

        }
    }

    private void validarEdad(LocalDate edad) {
        boolean result = Period.between(edad, LocalDate.now()).getYears() < 18;
        if(result){
            throw new ExcepcionDuplicidad(SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD);

        }
    }
    private void validarExistenciaPrevia(Alquiler alquiler) {
        if(this.daoAlquiler.existeUsuarioPorNationalId(alquiler.getNationalId())) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }



    }

    private void ejecutar(Alquiler alquiler) {
        this.servicioCrearAlquiler.crearAlquiler(alquiler);
    }




}
