package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;

public class ServicioValidarExistenciaUsuarioYPagosAlDia {


    public static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";
    public static final String EL_USUARIO_DEBE_PAGAR_ALQUILERES_PENDIENTES = "El usuario debe pagar alquileres pendientes";
    private final DaoRentAJetSki daoRentAJetSki;

    public ServicioValidarExistenciaUsuarioYPagosAlDia(DaoRentAJetSki daoRentAJetSki) {
        this.daoRentAJetSki = daoRentAJetSki;
    }

    public void validarExistenciaUsuarioYPagosAlDia(Alquiler alquiler) {
        validarExistenciaUsuario(alquiler.getCedula());
        validarPagosAlDia(alquiler.getCedula());

    }

    public void validarExistenciaUsuario(Long cedula) {

        if (!daoRentAJetSki.existeUsuarioPorCedula(cedula)) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void validarPagosAlDia(Long cedula) {

        if (!daoRentAJetSki.estaAlDiaElUsuario(cedula)) {
            throw new ExcepcionValorInvalido(EL_USUARIO_DEBE_PAGAR_ALQUILERES_PENDIENTES);
        }
    }
}
