package com.ceiba;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;
import static org.mockito.Mockito.*;

public class ServicioCrearUsuarioTest {

    @Test
    public void crearUsuarioYCrearAlquiler(){
        //Arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeUsuarioPorCedula(usuario.getCedula())).thenReturn(false);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioRentAJetSki, daoRentAJetSki);
        //Act
        servicioCrearUsuario.crearUsuario(usuario);
        //Assert
        verify(daoRentAJetSki, times(1)).existeUsuarioPorCedula(usuario.getCedula());
        verify(repositorioRentAJetSki,times(1)).crearAlquiler(alquiler);

    }

    @Test
    public void crearUsuarioConExcepcionLanzadaPorSerMiercoles(){
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        LocalDate localDateTime = LocalDate.from(mock(LocalDate.class).getDayOfWeek());
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioRentAJetSki, daoRentAJetSki);
        //Act - Assert
        BasePrueba.assertThrows(()-> servicioCrearUsuario.crearUsuario(usuario), ExcepcionValorInvalido.class,
                ServicioCrearUsuario.LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO);
    }
}
