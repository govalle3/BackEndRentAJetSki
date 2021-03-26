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
import java.util.List;

public class ServicioCrearAlquiler {

    public static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    public static final String EL_USUARIO_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER = "El usuario debe seleccionar minimo 10 minutos de alquiler";
    public static final String LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO = "Los dias miercoles no se presta servicio";
    public static final String SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD = "Solo se presta servicio a mayores de edad";
    public static final String LA_MOTO_SOLICITADA_SE_ENCUENTRA_ALQUILADA = "La moto seleccionada se encuentra alquilada";
    private final RepositorioAlquiler repositorioAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, DaoAlquiler daoAlquiler){
        this.repositorioAlquiler = repositorioAlquiler;
        this.daoAlquiler = daoAlquiler;
    }


    public void crearAlquiler(Alquiler alquiler) {
        validarMinimoDiezMinutos(alquiler.getRentTime());
        validWednesday();
        validarEdad(alquiler.getDob());
        validarExistenciaMotoAlquilada(alquiler.getIdJetSki());
        validarExistenciaPrevia(alquiler);

    }

    private void validarMinimoDiezMinutos(Integer rentTime) {
        int eligio = rentTime;
        if(eligio < 10) {
            throw new ExcepcionValorInvalido(EL_USUARIO_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER);
        }

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

    private void validarExistenciaMotoAlquilada(String idJetSki) {
        if(this.daoAlquiler.existeAlquilerMoto(idJetSki)) {
            throw new ExcepcionDuplicidad(LA_MOTO_SOLICITADA_SE_ENCUENTRA_ALQUILADA);
        }
    }

    private void validarExistenciaPrevia(Alquiler alquiler) {
        if(this.daoAlquiler.existeUsuarioPorNationalId(alquiler.getNationalId())) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
        ejecutar(alquiler);
    }
    public void ejecutar(Alquiler alquiler) {
        this.repositorioAlquiler.crearAlquiler(alquiler);
    }


}
