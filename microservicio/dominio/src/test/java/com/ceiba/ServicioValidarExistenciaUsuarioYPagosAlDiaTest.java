package com.ceiba;

import com.ceiba.usuario.excepcion.ExcepcionUsuarioMoroso;
import com.ceiba.usuario.excepcion.ExcepcionUsuarioNoExistente;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.servicio.ServicioValidarExistenciaUsuarioYPagosAlDia;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ServicioValidarExistenciaUsuarioYPagosAlDiaTest {

    @Test
    public void validarExistenciaDeUsuarioYLibreDePagos(){
        //Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeUsuarioPorCedula(alquiler.getCedula())).thenReturn(true);
        when(daoRentAJetSki.estaAlDiaElUsuario(alquiler.getCedula())).thenReturn(true);
        ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia = new ServicioValidarExistenciaUsuarioYPagosAlDia(daoRentAJetSki);
        // Act
        servicioValidarExistenciaUsuarioYPagosAlDia.validarExistenciaUsuarioYPagosAlDia(alquiler);
        // Assert
        verify(daoRentAJetSki, times(1)).existeUsuarioPorCedula(alquiler.getCedula());
    }

    @Test
    public void validarExistenciaDeUsuarioConExcepcionLanzadaNoExistencia(){
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeUsuarioPorCedula(alquiler.getCedula())).thenReturn(false);
        ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia = new ServicioValidarExistenciaUsuarioYPagosAlDia(daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioValidarExistenciaUsuarioYPagosAlDia.validarExistenciaUsuario(alquiler.getCedula()), ExcepcionUsuarioNoExistente.class,
                ServicioValidarExistenciaUsuarioYPagosAlDia.EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExistenciaDeUsuarioConExcepcionLanzadaFaltaDePagos(){
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.estaAlDiaElUsuario(alquiler.getCedula())).thenReturn(false);
        ServicioValidarExistenciaUsuarioYPagosAlDia servicioValidarExistenciaUsuarioYPagosAlDia = new ServicioValidarExistenciaUsuarioYPagosAlDia(daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioValidarExistenciaUsuarioYPagosAlDia.validarPagosAlDia(alquiler.getCedula()), ExcepcionUsuarioMoroso.class,
                ServicioValidarExistenciaUsuarioYPagosAlDia.EL_USUARIO_DEBE_PAGAR_ALQUILERES_PENDIENTES);
    }
}
