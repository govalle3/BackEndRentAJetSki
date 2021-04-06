package com.ceiba.usuario.servicio;

import com.ceiba.usuario.excepcion.ExcepcionUsuarioExistente;
import com.ceiba.usuario.excepcion.ExcepcionUsuarioMenorDeEdad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;

import java.time.LocalDate;
import java.time.Period;

public class ServicioCrearUsuario {

    public static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    public static final String SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD = "Solo se presta servicio a mayores de edad";
    public static final Integer EDAD_PERMITIDA_18 = 18;
    private final RepositorioRentAJetSki repositorioRentAJetSki;
    private final DaoRentAJetSki daoRentAJetSki;

    public ServicioCrearUsuario(RepositorioRentAJetSki repositorioRentAJetSki, DaoRentAJetSki daoRentAJetSki) {
        this.repositorioRentAJetSki = repositorioRentAJetSki;
        this.daoRentAJetSki = daoRentAJetSki;
    }

    public void crearUsuario(Usuario usuario){

        validarSiEsMayorDeEdad(usuario.getFechaNacido());
        validarSiExisteUsuario(usuario);
        crear(usuario);
    }

    private void crear(Usuario usuario) {
        this.repositorioRentAJetSki.crearUsuario(usuario);
    }

    private void validarSiEsMayorDeEdad(LocalDate edad) {
        boolean esMenorDeEdad = Period.between(edad, LocalDate.now()).getYears() < EDAD_PERMITIDA_18;
        if(esMenorDeEdad){
            throw new ExcepcionUsuarioMenorDeEdad(SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD);
        }
    }

    private void validarSiExisteUsuario(Usuario usuario) {
        if(this.daoRentAJetSki.existeUsuarioPorCedula(usuario.getCedula())) {
            throw new ExcepcionUsuarioExistente(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }




}
