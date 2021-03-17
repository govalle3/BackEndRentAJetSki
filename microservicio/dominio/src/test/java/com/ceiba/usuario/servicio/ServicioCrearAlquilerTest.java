package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import mockit.Expectations;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServicioCrearAlquilerTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        when(repositorioAlquiler.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.ejecutar(alquiler), ExcepcionDuplicidad.class,"El alquiler ya existe en el sistema");
    }

    @Test
    public void validarCrearAlquiler(){
        // Arrange
        String instantExpected = "2021-03-16T10:15:30Z";
        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));
        Instant instant = Instant.now(clock);
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        when(repositorioAlquiler.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
        // Act
        servicioCrearAlquiler.crearAlquiler(alquiler);
        // Assert
        verify(repositorioAlquiler,times(1)).crearAlquiler(alquiler);
    }















    @Test
    public void validarDiaMantenimiento() {

        Clock clock = Clock.fixed(Instant.parse("2014-12-23T10:15:30.00Z"), ZoneId.of("UTC"));
        LocalDateTime dateTimeExpected = LocalDateTime.now(clock);
        new Expectations(LocalDateTime.class) {
            {
                LocalDateTime.now();
                result = dateTimeExpected;
            }
        };

        LocalDateTime now = LocalDateTime.now();

        assertEquals(now.toString(), dateTimeExpected);

    }
}
