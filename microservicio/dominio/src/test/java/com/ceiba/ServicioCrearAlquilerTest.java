package com.ceiba;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioCrearAlquilerTest {

    @Test
    public void crearAlquiler() {

        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 50, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC001").conRentTime(20).
                conDateAndTimeRent(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        RepositorioAlquiler repositorioAlquiler = mock(RepositorioAlquiler.class);
        DaoAlquiler daoAlquiler = mock(DaoAlquiler.class);
        when(daoAlquiler.existeUsuarioPorNationalId(alquiler.getNationalId())).thenReturn(false);
        when(repositorioAlquiler.crearAlquiler(alquiler)).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);

        // Act
        servicioCrearAlquiler.crearAlquiler(alquiler);

        // Assert
        verify(daoAlquiler,times(1)).existeUsuarioPorNationalId(alquiler.getNationalId());
        verify(repositorioAlquiler,times(1)).crearAlquiler(alquiler);
    }

    @Test
    public void ValidarReglaDeNegocio10MinutosMinimoDeAlquiler() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC001").conRentTime(9).
                conDateAndTimeRent(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();

        // Act

        // Assert

    }
}
