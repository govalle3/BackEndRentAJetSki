package com.ceiba;

import com.ceiba.usuario.excepcion.ExcepcionUsuarioExistente;
import com.ceiba.usuario.excepcion.ExcepcionUsuarioMenorDeEdad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;

public class ServicioCrearUsuarioTest {

    @Test
    public void crearUsuario(){
        //Arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeUsuarioPorCedula(usuario.getCedula())).thenReturn(false);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioRentAJetSki, daoRentAJetSki);
        //Act
        servicioCrearUsuario.crearUsuario(usuario);
        //Assert
        verify(daoRentAJetSki, times(1)).existeUsuarioPorCedula(usuario.getCedula());
    }

    @Test
    public void crearUsuarioConExcepcionLanzadaPorMenorDeEdad(){
        // Arrange
        Usuario usuario = new UsuarioTestDataBuilder().conFechaNacido(LocalDate.of(2010, Month.MARCH, 26)).build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioRentAJetSki, daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.crearUsuario(usuario), ExcepcionUsuarioMenorDeEdad.class,
                ServicioCrearAlquiler.SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD);
    }

    @Test
    public void crearUsuarioConExcepcionPorExistenciaPreviaDeUsuario() {

        // Arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeUsuarioPorCedula(usuario.getCedula())).thenReturn(true);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioRentAJetSki, daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.crearUsuario(usuario), ExcepcionUsuarioExistente.class,
                ServicioCrearAlquiler.EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
    }

}
