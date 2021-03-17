package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;
import java.time.*;
import static org.junit.Assert.*;

public class ServicioPagarAlquilerTest {

    @Test
    public void pagarAlquilerJetSkiPrecio1() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC01").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2021,
                Month.MARCH, 17, 14, 24, 00)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,78000,0);
    }
    @Test
    public void pagarAlquilerJetSkiPrecio2() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC02").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,70000,0);
    }
    @Test
    public void pagarAlquilerJetSkiPrecio3() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC03").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,90000,0);
    }

    @Test
    public void pagarAlquilerJetSkiPrecio1ConMulta() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC01").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2021,
                Month.MARCH, 17, 8, 05, 00)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,78000,0);
    }
    @Test
    public void pagarAlquilerJetSkiPrecio2ConMulta() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC02").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,70000,0);
    }
    @Test
    public void pagarAlquilerJetSkiPrecio3ConMulta() {
        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC03").conRentTime(10).conDateAndTimeRent(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler();
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        assertEquals(result,90000,0);
    }
}