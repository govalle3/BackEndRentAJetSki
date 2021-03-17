package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearAlquilerTest {

    @Test
    public void validarClaveLongitudMenor4Test() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Alquiler alquiler = new UsuarioTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAlquiler servicioCrearUsuario = new ServicioCrearAlquiler(repositorioAlquiler);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(alquiler), ExcepcionDuplicidad.class,"El alquiler ya existe en el sistema");
    }
}
