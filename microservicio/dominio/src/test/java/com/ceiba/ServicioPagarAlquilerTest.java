package com.ceiba;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ServicioPagarAlquilerTest {

    private RepositorioAlquiler repositorioAlquiler;

    @Test
    public void pagarAlquilerJetSkiPrecio1SinMulta20Minutos() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 50, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC001").conRentTime(20).
                conDateAndTimeRent(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler(repositorioAlquiler);
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler, checkout);
        // Assert
        assertEquals(result,100000,0);
    }

    @Test
    public void pagarAlquilerJetSkiPrecio1ConMulta20MinutosMas3MinutosDeMulta() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 53, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC001").conRentTime(20).
                conDateAndTimeRent(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler(repositorioAlquiler);
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler, checkout);
        // Assert
        assertEquals(result,118000,0);
    }
}
