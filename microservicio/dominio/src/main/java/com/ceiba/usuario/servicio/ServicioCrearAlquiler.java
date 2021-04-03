package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioCrearAlquiler {

    public static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    public static final String EL_USUARIO_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER = "El usuario debe seleccionar minimo 10 minutos de alquiler";
    public static final String LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO = "Los dias miercoles no se presta servicio";
    public static final String SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD = "Solo se presta servicio a mayores de edad";
    public static final String LA_MOTO_SOLICITADA_SE_ENCUENTRA_ALQUILADA = "La moto seleccionada se encuentra alquilada";
    public static final Integer MINIMO_TIEMPO_ALQUILER_10 = 10;
    private final RepositorioRentAJetSki repositorioRentAJetSki;
    private final DaoRentAJetSki daoRentAJetSki;

    public ServicioCrearAlquiler(RepositorioRentAJetSki repositorioRentAJetSki, DaoRentAJetSki daoRentAJetSki){
        this.repositorioRentAJetSki = repositorioRentAJetSki;
        this.daoRentAJetSki = daoRentAJetSki;
    }

    public Long crearAlquiler(Alquiler alquiler) {
        validarSiElLugarSeEncuentraAbierto(); // logica del alquiler
        validarMinimoDiezMinutosDeAlquiler(alquiler.getTiempoRenta());
        validarExistenciaPreviaMotoSolicitada(alquiler.getIdJetSki());
        return crear(alquiler);
    }

    public Long crear(Alquiler alquiler) {
        return this.repositorioRentAJetSki.crearAlquiler(alquiler);


    }

    private void validarSiElLugarSeEncuentraAbierto() {
        DayOfWeek diaActual = LocalDateTime.now().getDayOfWeek();
        boolean esMiercoles = diaActual.name().equals(DayOfWeek.TUESDAY.name());
        if(esMiercoles){
            throw new ExcepcionValorInvalido(LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO);
        }
    }

    private void validarMinimoDiezMinutosDeAlquiler(Integer tiempoRenta) {
        int tiempoElegido = tiempoRenta;
         if(tiempoElegido < MINIMO_TIEMPO_ALQUILER_10) {
            throw new ExcepcionValorInvalido(EL_USUARIO_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER);
        }
    }

    private void validarExistenciaPreviaMotoSolicitada(String idJetSki) {
        if(this.daoRentAJetSki.existeAlquilerMoto(idJetSki)) {
            throw new ExcepcionDuplicidad(LA_MOTO_SOLICITADA_SE_ENCUENTRA_ALQUILADA);
        }
    }
}
