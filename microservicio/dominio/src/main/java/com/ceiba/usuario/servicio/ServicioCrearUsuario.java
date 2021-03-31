package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class ServicioCrearUsuario {

    public static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    public static final String LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO = "Los dias miercoles no se presta servicio";
    public static final String SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD = "Solo se presta servicio a mayores de edad";
    private final RepositorioRentAJetSki repositorioRentAJetSki;
    private final DaoRentAJetSki daoRentAJetSki;

    public ServicioCrearUsuario(RepositorioRentAJetSki repositorioRentAJetSki, DaoRentAJetSki daoRentAJetSki) {
        this.repositorioRentAJetSki = repositorioRentAJetSki;
        this.daoRentAJetSki = daoRentAJetSki;
    }

    public void crearUsuario(Usuario usuario){
        validarSiElLugarSeEncuentraAbierto();
        validarSiEsMayorDeEdad(usuario.getFechaNacido());
        validarSiExisteUsuario(usuario); // arreglar nombre
        crear(usuario);
    }

    private void crear(Usuario usuario) {
        this.repositorioRentAJetSki.crearUsuario(usuario);
    }

    private void validarSiElLugarSeEncuentraAbierto() {
        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        boolean result = dayOfWeek.name().equals(DayOfWeek.WEDNESDAY.name());
        if(result){
            throw new ExcepcionValorInvalido(LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO);
        }
    }

    private void validarSiEsMayorDeEdad(LocalDate edad) {
        int edadPermitida = 18;
        boolean result = Period.between(edad, LocalDate.now()).getYears() < edadPermitida;
        if(result){
            throw new ExcepcionDuplicidad(SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD);
        }
    }

    private void validarSiExisteUsuario(Usuario usuario) {
        if(this.daoRentAJetSki.existeUsuarioPorNationalId(usuario.getCedula())) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
